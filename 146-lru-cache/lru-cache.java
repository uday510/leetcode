class Node {
    Node prev;
    int k;
    int v;
    Node next;

    Node(int k, int v) {
        this.k = k;
        this.v = v;
    }
}
class LRUCache {
    Node head;
    Map<Integer, Node> cache;
    int capacity;
    Node tail;

    public LRUCache(int capacity) {
        cache = new HashMap<>();
        this.capacity = capacity;
        head = tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        int v = -1;
        if (!cache.containsKey(key)) return -1;

        Node node = cache.get(key);
        v = node.v;
        remove(node);
        add(node);

        return v;
    }
    
    public void put(int key, int value) {
        Node nodeToBeAdded = null;
        if (cache.containsKey(key)) {
            nodeToBeAdded = cache.get(key);
            nodeToBeAdded.v = value;
            remove(nodeToBeAdded);
        } else {
            if (cache.size() == capacity) remove(head.next);
            nodeToBeAdded = new Node(key, value);
        }  
        
        add(nodeToBeAdded); 
    }

    private void remove(Node node) {
        cache.remove(node.k);

        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void add(Node newNode) {
        cache.put(newNode.k, newNode);

        Node tailPrev = tail.prev;

        newNode.prev = tailPrev;
        tailPrev.next = newNode;
        newNode.next = tail;
        tail.prev = newNode;
    }
}


/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */