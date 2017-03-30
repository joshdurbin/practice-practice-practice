import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertTrue;

public class TestSimpleTree {

    final SimpleTree<Integer> treeOfNumbers = new SimpleTree<>(10);

    @Before
    public void init() {

        treeOfNumbers.insert(5);
        treeOfNumbers.insert(15);
        treeOfNumbers.insert(3);
        treeOfNumbers.insert(7);
    }

    @Test
    public void executeMaxWidthQuery() {

        treeOfNumbers.insert(20);
        assertTrue(treeOfNumbers.maxWidthOfTree() == 3);
    }

    @Test
    public void executeBFSTraversal() {

        assertTrue(treeOfNumbers.bfsTraversal().equals(Arrays.asList(10, 5, 15, 3, 7)));
    }

    @Test
    public void executeDFSTraversal() {

        assertTrue(treeOfNumbers.dfsTraversal().equals(Arrays.asList(10, 5, 3, 7, 15)));
    }

    @Test
    public void insertedValueShouldExist() {

        assertTrue(treeOfNumbers.exists(3));
        assertTrue(treeOfNumbers.bfsSearch(3));
        assertTrue(treeOfNumbers.dfsSearch(3));
    }

    @Test
    public void sizeShouldReportItselfProperly() {

        assertTrue(treeOfNumbers.size() == 5);
    }
}
