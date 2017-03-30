import java.util.NoSuchElementException;

public class CustomQueue<T> {

    private Integer size;
    private Node first;
    private Node last;

    public CustomQueue() {

        size = 0;
    }

    public CustomQueue<T> enqueue(final T value) {

        final Node current = last;
        last = new Node(value);

        if (size++ == 0) {
            first = last;
        } else {
            current.next = last;
        }

        return this;
    }

    public T dequeue() {

        if (size == 0) {
            throw new NoSuchElementException();
        }

        final T dequeuedVaue = (T) first.value;
        first = first.next;

        if (--size == 0) {
            last = null;
        }

        return dequeuedVaue;
    }

    public static class Node<T> {

        public final T value;
        public Node<T> next;

        public Node(T value) {
            this.value = value;
        }
    }
}

