class Node {
    int key;
    int value;
    Node prev;
    Node next;
    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}
public class LRUCache {
    Map<Integer, Node> cache;
    int capacity;
    Node head;
    Node tail;

    public LRUCache(int capacity) {
        this.cache = new HashMap<>(capacity);
        this.capacity = capacity;
        this.head = new Node(-1, -1);
        this.tail = new Node(-1, -1);
        this.head.next = this.tail;
        this.tail.prev = this.head;
    }

    public int get(int key) {

        if (!cache.containsKey(key)) {
            return -1;
        }

        Node node = cache.get(key);
        remove(node);
        addToTail(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            node.value = value;
            remove(node);
            addToTail(node);
        } else {
            if (cache.size() == capacity) {
                Node lru = head.next;
                this.cache.remove(lru.key);
                remove(lru);
            }
            Node node = new Node(key, value);
            cache.put(key, node);
            addToTail(node);
        }
    }

    private void addToTail(Node node) {
        this.tail.prev.next = node;
        node.prev = this.tail.prev;
        node.next = tail;
        tail.prev = node;
    }

    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
}