import org.junit.Before;
import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TestCustomDataStructures {

    CustomLinkedList<Integer> listOfNumbers;
    CustomQueue<Integer> queueOfNumbers;
    CustomStack<Integer> stackOfNumbers;

    @Before
    public void init() {

        listOfNumbers = new CustomLinkedList<>();

        listOfNumbers.add(1);
        listOfNumbers.add(2);
        listOfNumbers.add(3);
        listOfNumbers.add(4);
        listOfNumbers.add(5);

        //////////////////////////
        queueOfNumbers = new CustomQueue<>();

        queueOfNumbers.enqueue(10);
        queueOfNumbers.enqueue(9);
        queueOfNumbers.enqueue(8);

        //////////////////////////
        stackOfNumbers = new CustomStack<>();
        stackOfNumbers.push(3);
        stackOfNumbers.push(2);
        stackOfNumbers.push(1);
    }

    @Test
    public void thingThingThingTwo() {

        MapWithValueSets<Integer, String> mvs = new MapWithValueSets<>();

        mvs.put(1, "Josh");
        mvs.put(1, "Andrea");

        assertTrue(mvs.get(1).contains("Josh"));
        assertTrue(mvs.get(1).contains("Andrea"));

        mvs.deleteValue(1, "Josh");

        assertFalse(mvs.get(1).contains("Josh"));
    }

    @Test
    public void thingThingThing() {

        CustomLinkedList<String> abc = new CustomLinkedList<>();

        abc.add("s");
        abc.add("h");
        abc.add("i");
        abc.add("t");

        final String thing = (String) abc.findMiddle().value;

        assertTrue(true);
    }

    @Test
    public void dingleBerry() {

        assertTrue(stackOfNumbers.pop() == 1);
        assertTrue(stackOfNumbers.pop() == 2);
        assertTrue(stackOfNumbers.pop() == 3);
    }

    @Test
    public void dingleBerryWierd() {

        assertTrue(stackOfNumbers.pop() == 1);
        assertTrue(stackOfNumbers.pop() == 2);

        stackOfNumbers.push(4);

        assertTrue(stackOfNumbers.pop() == 4);
        assertTrue(stackOfNumbers.pop() == 3);
    }

    @Test(expected = NoSuchElementException.class)
    public void dingleBerryDo() {

        stackOfNumbers.pop();
        stackOfNumbers.pop();
        stackOfNumbers.pop();
        stackOfNumbers.pop();
    }

    @Test
    public void sizeShouldReportItselfAsFiveTinkerBell() {

        assertTrue(queueOfNumbers.dequeue() == 10);
        assertTrue(queueOfNumbers.dequeue() == 9);
        assertTrue(queueOfNumbers.dequeue() == 8);
    }

    @Test(expected = NoSuchElementException.class)
    public void sizeShouldReportItselfAsFiveTinkerBellThing() {

        queueOfNumbers.dequeue();
        queueOfNumbers.dequeue();
        queueOfNumbers.dequeue();
        queueOfNumbers.dequeue();
    }


    @Test
    public void sizeShouldReportItselfAsFive() {

        assertTrue(listOfNumbers.getSize() == 5);
    }

    @Test
    public void findMiddleNode() {

        assertTrue((Integer) listOfNumbers.findMiddle().value == 3);
    }
}
