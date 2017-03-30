import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class WordBreakProblem {

    final Set<String> knownWords;
    final Map<String, String> cache;

    public WordBreakProblem(Set<String> knownWords) {
        this.knownWords = knownWords;
        this.cache = new HashMap<>();
    }

    public String segmentInputIntoWords(final String input) {

        if (knownWords.contains(input)) {
            return input;
        }

        if (cache.containsKey(input)) {
            return cache.get(input);
        }

        final Integer lengthOfInput = input.length();

        for (Integer i = 1; i < lengthOfInput; i++) {

            final String subWord = input.substring(0, i);

            if (knownWords.contains(subWord)) {

                final String remainder = input.substring(i, lengthOfInput);
                final String remainingWords = segmentInputIntoWords(remainder);

                if (remainingWords != null) {

                    final String concatenatedResponse = subWord + " " + remainingWords;

                    cache.put(input, concatenatedResponse);
                    return concatenatedResponse;
                }
            }
        }

        cache.put(input, null);
        return null;
    }

}
