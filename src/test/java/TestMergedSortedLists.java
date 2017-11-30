import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestMergedSortedLists {

    List<Integer> firstList = new ArrayList<>();
    List<Integer> secondList = new ArrayList<>();
    List<Integer> thirdList = new ArrayList<>();

    List<List<Integer>> listOfLists = new ArrayList<>();

    @Before
    public void init() {

        firstList.add(1);
        firstList.add(4);
        firstList.add(8);

        secondList.add(-20);
        secondList.add(-10);
        secondList.add(2);

        thirdList.add(33);
        thirdList.add(-1000);
        thirdList.add(99);
        thirdList.add(4500);
        thirdList.add(-2000);

        listOfLists.add(firstList);
        listOfLists.add(secondList);
        listOfLists.add(thirdList);
    }

    @Test
    public void asdf() {

        List<Integer> targetList = new ArrayList<>();

        targetList.add(-2000);
        targetList.add(-1000);
        targetList.add(-20);
        targetList.add(-10);
        targetList.add(1);
        targetList.add(2);
        targetList.add(4);
        targetList.add(8);
        targetList.add(33);
        targetList.add(99);
        targetList.add(4500);

        assertEquals(MergeMultipleListsIntoOneSortedList.getFinalSortedList(listOfLists), targetList);
    }
}
