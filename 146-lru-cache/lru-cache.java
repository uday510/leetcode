class LRUCache {

    Node head;
    Node tail;
    Map<Integer, Node> cache;
    int capacity;

    public LRUCache(int capacity) {
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        cache = new HashMap<>();
        this.capacity = capacity;

        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        int value = -1;

        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            remove(node);
            insert(node);
            value = node.value;
        }
        return value;
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
        head.next = node;
        node.prev = head;
        node.next = headNext;
        headNext.prev = node;
    }

    private void remove(Node node) {
        cache.remove(node.key);

        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private class Node {
        Node prev;
        Node next;
        int key;
        int value;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

}

