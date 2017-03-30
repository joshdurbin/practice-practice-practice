import java.util.NoSuchElementException;

public class CustomStack<T> {

    private Node first = null;

    public CustomStack() {
    }

    public void push(final T valueToPush) {

        final Node nodeToInsert = new Node(valueToPush);
        nodeToInsert.next = first;
        first = nodeToInsert;
    }

    public T pop() {

        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        final Node poppedNode = first;
        first = first.next;

        return (T) poppedNode.value;
    }

    public Boolean isEmpty() {

        return first == null;
    }

    public static class Node<T> {

        public final T value;
        public Node<T> next;

        public Node(T value) {
            this.value = value;
        }
    }
}

