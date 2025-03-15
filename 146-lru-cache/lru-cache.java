class Node {
    Node prev;
    int key;
    int val;
    Node next;

    Node(int key, int val) {
        this.key = key;
        this.val = val;
    }
}
class LRUCache {
    Map<Integer, Node> cache;
    int capacity;
    Node head;
    Node tail;
    public LRUCache(int capacity) {
        cache = new HashMap<>();
        this.capacity = capacity;

        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
    }
    public int get(int key) {
        if (!cache.containsKey(key)) 
            return -1;

        Node existing = cache.get(key);
        remove(existing);
        addToTail(existing);

        return existing.val;
    }
    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            Node existing = cache.get(key);
            existing.val = value;
            remove(existing);
            addToTail(existing);
            return;
        }

        if (cache.size() == capacity) {
            Node lru = head.next;
            cache.remove(lru.key);
            remove(lru);
        } 

        Node newNode = new Node(key, value);
        addToTail(newNode);
    }
    private void addToTail(Node node) {
        cache.put(node.key, node);

        Node tailPrev = tail.prev;
        tailPrev.next = node;
        node.prev = tailPrev;
        node.next = tail;
        tail.prev = node;
    }
    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
}
