import java.util.*;

public class EfficientAnagramFinder {

    final Map<String, List<String>> dictionary = new HashMap<>();

    public EfficientAnagramFinder(final List<String> onLoadDictionary) {

        // we store the words in the supplied dictionary on instantiation so that lookups are fast
        onLoadDictionary.forEach(s -> { addDictionaryWord(s); } );
    }

    private static String getSignature(final String word) {

        final byte[] bytes = word.getBytes();
        Arrays.sort(bytes);

        return new String(bytes);
    }

    public void addDictionaryWord(final String wordToAdd) {

        final String signature = getSignature(wordToAdd);

        if (dictionary.containsKey(signature)) {

            dictionary.get(signature).add(wordToAdd);

        } else {

            final List<String> anagramList = new ArrayList<>();
            anagramList.add(wordToAdd);
            dictionary.put(signature, anagramList);
        }
    }

    public List<String> getAnagrams(final String word) {

        final String signature = getSignature(word);
        final List<String> anagrams = dictionary.get(signature);

        return anagrams == null ? new ArrayList<>() : anagrams;
    }
}