import java.util.HashMap;
import java.util.Map;

public class LRUCache<K, V> {

    private final Integer capacity;
    private DoubleLinkedListNode head;
    private DoubleLinkedListNode tail;
    private final Map<K, DoubleLinkedListNode> map;

    public LRUCache(final Integer capacity) {

        this.capacity = capacity;
        this.head = null;
        this.tail = null;
        this.map = new HashMap<K, DoubleLinkedListNode>();
    }

    public V get(K key) {

        final V result;

        if (map.containsKey(key)) {

            // cache hit
            final DoubleLinkedListNode node = map.get(key);

            // if the node is at the head, it's already the most recently accessed, so we don't need to do anything
            if (!node.equals(head)) {

                if (node.equals(tail)) {

                    // if the node is the tail, we need to move it and set the previous node to the tail
                    node.prev.next = null;
                    tail = node.prev;

                } else {

                    // if the node is in between the head and tail, then we set the next and previous to link to each other
                    node.prev.next = node.next;
                    node.next.prev = node.prev;
                }

                // set the node as the head and move it to the front of the linked list
                node.prev = null;
                node.next = head;
                head.prev = node;
                head = node;
            }

            result = node.val;

        } else {

            result = null;
        }

        return result;
    }

    public void put(K key, V val) {

        V existingValue = get(key);

        if (existingValue != null && !val.equals(existingValue)) {

            head.val = val;

        } else if (existingValue == null) {

            // cache miss
            final DoubleLinkedListNode node = new DoubleLinkedListNode(key, val);
            map.put(key, node);

            if (head == null) {

                // empty cache
                head = node;
                tail = node;

            } else {

                node.next = head;
                head.prev = node;
                head = node;
            }

            trimToCapacity();
        }
    }

    public Integer size() {

        return map.size();
    }

    private void trimToCapacity() {

        if (map.size() > capacity) {

            map.remove(tail.key);

            if (tail.prev == null) {

                head = null;
                tail = null;

            } else {

                tail.prev.next = null;
                tail = tail.prev;
            }
        }
    }

    private class DoubleLinkedListNode {

        public K key;
        public V val;
        public DoubleLinkedListNode prev;
        public DoubleLinkedListNode next;

        public DoubleLinkedListNode(K key, V val) {

            this.key = key;
            this.val = val;
            prev = null;
            next = null;
        }
    }
}