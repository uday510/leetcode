class LFUCache {

    private final int capacity;
    private int minFreq;
    private final Map<Integer, Node> lfu;
    private final Map<Integer, DLL> freqMap;

    LFUCache (int capacity) {
        this.capacity = capacity;
        this.minFreq = 0;
        this.lfu = new HashMap<>();
        this.freqMap = new HashMap<>();
    }

    public int get(int key) {
        Node node = lfu.get(key);
        if (node == null) return -1;

        updateFrequence(node);
        return node.v;
    }
    
    public void put(int key, int value) {
        if (capacity == 0) return;
        
        Node node = lfu.get(key);
        if (node != null) {
            node.v = value;
            updateFrequence(node);
            return;
        }
        
        if (lfu.size() >= capacity) {
            DLL minList = freqMap.get(minFreq);
            Node nodeToEvict = minList.removeHead();
            assert nodeToEvict != null;
            lfu.remove(nodeToEvict.k);
        }
        
        node = new Node(key, value);
        lfu.put(node.k, node);
        freqMap.computeIfAbsent(1, k -> new DLL()).add(node);
        minFreq = 1;
    }

    private void updateFrequence(Node node) {
        int oldFreq = node.freq;

        DLL oldList = freqMap.get(oldFreq);
        oldList.remove(node);

        if (oldList.isEmpty() && oldFreq == minFreq) {
            minFreq++;
        }
        
        node.freq++;
        freqMap.computeIfAbsent(node.freq, k -> new DLL()).add(node);
    }
    
    static class Node {
        Node prev, next;
        int k, v, freq;

        Node (int k, int v) {
            this.k = k;
            this.v = v;
            this.freq = 1;
        }
    }

    static class DLL {
        Node head, tail;
        int size;

        DLL () {
            head = new Node(-1, -1);
            tail = new Node(-1, -1);
            tail.prev = head;
            head.next = tail;
            size = 0;
        }

        void add(Node node) {
            Node tailPrev = tail.prev;
            node.prev = tailPrev;
            tailPrev.next = node;
            tail.prev = node;
            node.next = tail;
            size++;
        }
        
        Node removeHead() {
            if (size == 0) return null;
            Node node = head.next;
            remove(node);
            return node;
        }

        void remove(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            size--;
        }

        boolean isEmpty() {
            return size == 0;
        }
    }
}
