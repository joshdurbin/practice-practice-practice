import java.util.*;

public class NumberProblems {

    public static List<String> findAllCombinationsOfNumbersSumming(final List<Integer> numbers, final Integer targetSum) {

        List<String> combinations = new ArrayList<>();

        if (numbers.size() > 2) {

            final Set set = new HashSet(numbers.size());

            for (final Integer number : numbers) {

                final Integer targetDiff = targetSum - number;

                if (set.contains(targetDiff)) {

                    final String output = number + "-" + targetDiff;

                    combinations.add(output);

                } else {

                    set.add(number);
                }
            }
        }

        return combinations;
    }
}
