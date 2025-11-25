class LRUCache {
    
    private final Map<Integer, Node> lru;
    private final int capacity;
    private Node head, tail;

    public LRUCache(int capacity) {
        lru = new HashMap<>();
        this.capacity = capacity;
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        Node cur = lru.get(key);
        if (cur == null) return -1;

        remove(cur);
        add(cur);

        return cur.v;
    }

    private void add(Node node) {
        lru.put(node.k, node);

        Node tailPrev = tail.prev;
        node.prev = tailPrev;
        tailPrev.next = node;
        node.next = tail;
        tail.prev = node;
    }

    private void remove(Node node) {
        lru.remove(node.k);

        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    
    public void put(int key, int value) {
        Node cur = lru.get(key);
        
        if (cur != null) {
            remove(cur);
            cur.v = value;
        } else {
            if (lru.size() == capacity) {
                remove(head.next);
            }
            cur = new Node(key, value);
        }

        add(cur);
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