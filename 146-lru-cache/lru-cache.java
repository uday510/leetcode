class Node<T1, T2> {
    Node prev;
    T1 k;
    T2 v;
    Node next;

    Node(T1 k, T2 v) {
        this.k = k;
        this.v = v;
    }
}
class LRUCache {
    Node head;
    Map<Integer, Node<Integer, Integer>> lru;
    int capacity;
    Node tail;

    public LRUCache(int capacity) {
        lru = new HashMap<>();
        this.capacity = capacity;
        head = tail = new Node<Integer, Integer>(-1, -1);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        int v = -1;
        if (!lru.containsKey(key)) return -1;

        var node = lru.get(key);
        v = node.v;
        remove(node);
        add(node);

        return v;
    }
    
    public void put(int key, int value) {
        Node<Integer, Integer> nodeToBeAdded = null;
        if (lru.containsKey(key)) {
            nodeToBeAdded = lru.get(key);
            nodeToBeAdded.v = value;
            remove(nodeToBeAdded);
        } else {
            if (lru.size() == capacity) remove(head.next);
            nodeToBeAdded = new Node<Integer, Integer>(key, value);
        }  
        
        add(nodeToBeAdded); 
    }

    private void remove(Node node) {
        lru.remove(node.k);

        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void add(Node<Integer, Integer> newNode) {
        lru.put(newNode.k, newNode);

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