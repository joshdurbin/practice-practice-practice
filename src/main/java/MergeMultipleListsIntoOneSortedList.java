import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class MergeMultipleListsIntoOneSortedList {

    public static List<Integer> getFinalSortedList(List<List<Integer>> listOfSortedLists) {

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        for( List<Integer> sortedList: listOfSortedLists){
            priorityQueue.addAll(sortedList);
        }

        List<Integer> sortedList = new ArrayList<>();

        while (priorityQueue.iterator().hasNext()) {
            sortedList.add(priorityQueue.poll());
        }

        return sortedList;
    }
}
