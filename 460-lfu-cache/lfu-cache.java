class LFUCache {

    private final int capacity;
    private int minFreq;
    private final Map<Integer, Node> lfu;
    private final Map<Integer, DoublyLinkedList> freqMap;
    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.minFreq = 0;
        this.lfu = new HashMap<>();
        this.freqMap = new HashMap<>();
    }

    public int get(int key) {
        Node node = lfu.get(key);
        if (node == null) return -1;
        updateFrequency(node);
        return node.v;
    }

    public void put(int key, int value) {
        if (capacity == 0) return;

        Node node = lfu.get(key);
        if (node != null) {
            node.v = value;
            updateFrequency(node);
            return;
        }

        if (lfu.size() >= capacity) {
            DoublyLinkedList minList = freqMap.get(minFreq);
            Node nodeToEvict = minList.removeHead();
            assert nodeToEvict != null;
            lfu.remove(nodeToEvict.k);
        }
        
        Node newNode = new Node(key, value);
        lfu.put(key, newNode);
        freqMap.computeIfAbsent(1, _ -> new DoublyLinkedList()).addNode(newNode);
        minFreq = 1;
    }

    private void updateFrequency(Node node) {
        int oldFreq = node.freq;
        DoublyLinkedList oldList = freqMap.get(oldFreq);
        oldList.removeNode(node);

        if (oldList.isEmpty() && oldFreq == minFreq) {
            minFreq++;
        }

        node.freq++;
        freqMap.computeIfAbsent(node.freq, _ -> new DoublyLinkedList()).addNode(node);
    }

    private static class Node {
        int k, v, freq;
        Node prev, next;

        Node(int k, int v) {
            this.k = k;
            this.v = v;
            this.freq = 1;
        }
    }

    private static class DoublyLinkedList {
        Node head, tail;
        int size;

        DoublyLinkedList() {
            head = new Node(-1, -1);
            tail = new Node(-1, -1);
            head.next = tail;
            tail.prev = head;
            size = 0;
        }

        void addNode(Node node) {
            Node tailPrev = tail.prev;
            node.prev = tailPrev;
            tailPrev.next = node;
            node.next = tail;
            tail.prev = node;
            size++;
        }

        Node removeHead() {
            if (size == 0) return null;
            Node node = head.next;
            removeNode(node);
            return node;
        }

        void removeNode(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            size--;
        }

        boolean isEmpty() {
            return size == 0;
        }
    }
}
