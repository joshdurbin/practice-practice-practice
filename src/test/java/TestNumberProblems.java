import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertTrue;

public class TestNumberProblems {

    @Test
    public void testCombinations() {

        final List<String> combinations = NumberProblems.findAllCombinationsOfNumbersSumming(Arrays.asList(2, 4, 10, 7, 8, 9, 7), 14);
        assertTrue(combinations.equals(Arrays.asList("10-4", "7-7")));
    }

}