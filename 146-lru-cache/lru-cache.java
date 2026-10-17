class LRUCache {

    private Node head, tail;
    private Map<Integer, Node> lru;
    private int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;

        head = new Node(0, 0);
        tail = new Node(0, 0);

        head.next = tail;
        tail.prev = head;

        lru = new HashMap<>();
    }
    
    public int get(int key) {
        Node node = lru.get(key);

        if (node == null) 
            return -1;
        
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
    int key, value;
    Node prev, next;

    Node (int key, int value) {
        this.key = key;
        this.value = value;
    }
}