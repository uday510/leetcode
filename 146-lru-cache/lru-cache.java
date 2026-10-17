class LRUCache {

    private Node head, tail;
    private Map<Integer, Node> lru;
    private int capacity;

    public LRUCache(int capacity) {
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        lru = new HashMap<>();
        head.next = tail;
        tail.prev = head;
        this.capacity = capacity;
    }
    
    public int get(int key) {
        Node node = lru.get(key);
        if (node == null) return -1;

        remove(node);
        add(node);

        return node.value;
    }
    
    public void put(int key, int value) {
        Node node = lru.get(key);

        if (node != null) {
            remove(node);
            node.value = value;
        } else {
            if (lru.size() == capacity) {
                remove(head.next);
            }
            node = new Node(key, value);
        }

        add(node);
    }

    private void remove(Node node) {
        lru.remove(node.key);

        node.next.prev = node.prev;
        node.prev.next = node.next;
    }

    private void add(Node node) {
        lru.put(node.key, node);

        Node tailPrev = tail.prev;
        tailPrev.next = node;
        node.prev = tailPrev;

        tail.prev = node;
        node.next = tail;
    }
}

class Node {
    Node prev, next;
    int key, value;

    Node (int k, int v) {
        this.key = k;
        this.value = v;
    }
}