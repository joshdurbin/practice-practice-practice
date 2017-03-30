import java.util.*;

public class SimpleTree<T extends Comparable> {

    public final T value;
    public SimpleTree<T> left;
    public SimpleTree<T> right;

    public SimpleTree(T value) {
        this.value = value;
    }

    public Integer size() {

        final Integer leftSize = left != null ? left.size() : 0;
        final Integer rightSize = right != null ? right.size() : 0;

        return 1 + leftSize + rightSize;
    }

    public Boolean exists(final T searchValue) {

        if (value.equals(searchValue)) {
            return true;
        } else if (searchValue.compareTo(value) < 0 && left != null) {
            return left.exists(searchValue);
        } else if (right != null) {
            return right.exists(searchValue);
        } else {
            return false;
        }
    }

    public void insert(final T toInsert) {

        if (toInsert.compareTo(value) < 0) {

            if (left == null) {
                left = new SimpleTree<T>(toInsert);
            } else {
                left.insert(toInsert);
            }

        } else {
            if (right == null) {
                right = new SimpleTree<T>(toInsert);
            } else {
                right.insert(toInsert);
            }
        }
    }

    public Integer maxDepthOfTree() {

        // todo
        return 0;
    }

    public Integer maxWidthOfTree() {

        final Queue<SimpleTree<T>> queue = new LinkedList<>();
        queue.add(this);

        Integer maxWidth = 0;
        Integer levelWidth;

        while (!queue.isEmpty()) {

            levelWidth = queue.size();

            if (levelWidth > maxWidth) {
                maxWidth = levelWidth;
            }

            while (levelWidth > 0) {

                final SimpleTree<T> current = queue.poll();

                if (current.left != null) queue.add(current.left);
                if (current.right != null) queue.add(current.right);

                levelWidth--;
            }
        }

        return maxWidth;
    }

    public Boolean dfsSearch(T searchValue) {

        final Stack<SimpleTree<T>> stack = new Stack<>();
        stack.push(this);

        while (!stack.isEmpty()) {

            final SimpleTree<T> current = stack.pop();

            if (current.value == searchValue) {
                return true;
            }

            if (current.right != null) stack.push(current.right);
            if (current.left != null) stack.push(current.left);
        }

        return false;
    }

    // level order traversal
    public List<T> dfsTraversal() {

        final List<T> outputs = new ArrayList<>();

        final Stack<SimpleTree<T>> stack = new Stack<>();
        stack.push(this);

        while (!stack.isEmpty()) {

            final SimpleTree<T> current = stack.pop();

            outputs.add(current.value);

            if (current.right != null) stack.push(current.right);
            if (current.left != null) stack.push(current.left);
        }

        return outputs;
    }

    public Boolean bfsSearch(T searchValue) {

        final Queue<SimpleTree<T>> queue = new LinkedList<>();
        queue.add(this);

        while (!queue.isEmpty()) {

            final SimpleTree<T> current = queue.poll();

            if (current.value.equals(searchValue)) {
                return true;
            }

            if (current.left != null) queue.add(current.left);
            if (current.right != null) queue.add(current.right);
        }

        return false;
    }

    public List<T> bfsTraversal() {

        final List<T> outputs = new ArrayList<>();

        final Queue<SimpleTree<T>> queue = new LinkedList<>();
        queue.add(this);

        while (!queue.isEmpty()) {

            final SimpleTree<T> current = queue.poll();

            outputs.add(current.value);

            if (current.left != null) queue.add(current.left);
            if (current.right != null) queue.add(current.right);
        }

        return outputs;
    }

}
