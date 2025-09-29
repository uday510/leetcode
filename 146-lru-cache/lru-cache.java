class LRUCache {

    private final Map<Integer, Node> lru;
    private final Node head, tail;
    private int capacity;

    public LRUCache(int capacity) {
        lru = new HashMap<>();
        this.capacity = capacity;
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if (!lru.containsKey(key)) return -1;

        Node node = lru.get(key);

        remove(node);
        add(node);

        return node.v;
    }
    
    public void put(int key, int value) {
        Node node = null;

        if (lru.containsKey(key)) {
            node = lru.get(key);
            node.v = value;
            remove(node);
        } else {
            if (lru.size() == capacity) {
                remove(head.next);
            }
            node = new Node(key, value);
        }

        add(node);
    }
    
    private void add(Node node) {
        lru.put(node.k, node);

        Node tailPrev = tail.prev;

        tailPrev.next = node;
        node.prev = tailPrev;

        node.next = tail;
        tail.prev = node;
    }

    private void remove(Node node) {
        lru.remove(node.k);

        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
}

class Node {
    Node prev, next;
    int k, v;

    Node (int k, int v) {
        this.k = k;
        this.v = v;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */