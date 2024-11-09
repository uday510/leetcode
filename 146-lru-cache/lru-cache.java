class LRUCache {
    Node head = new Node(-1, -1);
    Node tail = new Node(-1, -1);
    Map<Integer, Node> map;
    int capacity;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<Integer, Node>();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node _node = map.get(key);
            remove(_node);
            insert(_node);

            return _node.val;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            remove(node);
        } else if (map.size() == capacity) {
            remove(tail.prev);
        }
        insert(new Node(key, value));
    }
    private void insert(Node _node) {
        map.put(_node.key, _node);
        Node headNext = head.next;
        head.next = _node;
        _node.prev = head;
        _node.next = headNext;
        headNext.prev = _node;
    }
    private void remove(Node _node) {
        map.remove(_node.key);
        _node.prev.next = _node.next;
        _node.next.prev = _node.prev;
    }
    private class Node {
        Node prev;
        int key;
        int val;
        Node next;

        Node(int _key, int _val) {
            key = _key;
            val = _val;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */