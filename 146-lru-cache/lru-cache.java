class LRUCache {
    Node head;
    Node tail;
    Map<Integer, Node> cache;
    int capacity;
    public LRUCache(int capacity) {
        cache = new HashMap<>();
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            remove(node);
            insert(node);

            return node.val;
        } else {
            return -1;
        }
    }
    
    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            remove(node);
        } else if (cache.size() == capacity) {
            remove(tail.prev);
        }
        insert(new Node(key, value));
    }
    private void insert(Node node) {
        cache.put(node.key, node);

        Node headNext = head.next;
        node.prev = head;
        node.next = headNext;
        head.next = node;
        headNext.prev = node;
    }
    private void remove(Node node) {
        cache.remove(node.key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    private class Node {
        Node prev;
        int key;
        int val;
        Node next;

        Node (int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
}
