class Node {
    Node prev;
    int key;
    int val;
    Node next;

    Node (int key, int val) {
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
        if (!cache.containsKey(key)) return -1;
        
        Node node = cache.get(key);
        
        remove(node);
        addToTail(node);
        
        return node.val;
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            remove(node);
            node.val = value;
            addToTail(node);
            return;
        }
        
        if (cache.size() >= capacity) {
            Node lru = head.next;
            remove(lru);
            cache.remove(lru.key);
        }
        
        Node newNode = new Node(key, value);
        addToTail(newNode);
        cache.put(key, newNode);
    }
    
    private void addToTail(Node node) {
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