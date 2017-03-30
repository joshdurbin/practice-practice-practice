public class CustomLinkedList<T> {

    private Node<T> head;
    private Integer size;

    public CustomLinkedList() {

        head = null;
        size = 0;
    }

    public Node findMiddle() {

        Node slowPointer = head;
        Node fastPointer = head;

        while (fastPointer != null) {

            fastPointer = fastPointer.next;

            if (fastPointer != null && fastPointer.next != null) {

                slowPointer = slowPointer.next;
                fastPointer = fastPointer.next;
            }
        }

        return slowPointer;
    }

    public Node add(T value) {

        final Node<T> nodeToInsert = new Node(value);

        if (head == null) {

            head = nodeToInsert;

        } else {

            Node<T> zipper = head;

            while (zipper.next != null) {
                zipper = zipper.next;
            }

            zipper.next = nodeToInsert;
        }

        size++;

        return nodeToInsert;
    }

    public Integer getSize() {

        return size;
    }

    public static class Node<T> {

        public final T value;
        public Node<T> next;

        public Node(T value) {
            this.value = value;
        }
    }
}
