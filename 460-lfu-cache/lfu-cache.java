class LFUCache {

    Map<Integer, Node> lfu;
    Map<Integer, DLL> freqMap;
    int capacity, minFreq;

    public LFUCache(int capacity) {

        this.lfu = new HashMap<>();
        this.freqMap = new HashMap<>();
        this.capacity = capacity;
        this.minFreq = 0;

    }
    
    public int get(int key) {
        Node node = lfu.get(key);

        if (node == null) return -1;

        updateFreq(node);

        return node.v;
    }
    
    public void put(int key, int value) {
        if (capacity == 0) return;

        Node node = lfu.get(key);

        if (node != null) {
            node.v = value;
            updateFreq(node);
            return;
        }

        if (lfu.size() == capacity) {
            DLL minList = freqMap.get(minFreq);
            Node nodeToEvict = minList.evictHeadNext();
            lfu.remove(nodeToEvict.k);
        }

        node = new Node(key, value);
        lfu.put(node.k, node);
        freqMap.computeIfAbsent(1, k -> new DLL()).add(node);
        minFreq = 1;
    }

    private void updateFreq(Node node) {

        int oldFreq = node.freq;

        DLL oldList = freqMap.get(oldFreq);
        oldList.remove(node);

        if (oldList.isEmpty() && oldFreq== minFreq) minFreq++;

        node.freq++;
        freqMap.computeIfAbsent(node.freq, k -> new DLL()).add(node);

    }
}

class Node {
    Node prev, next;

    int k, v, freq;

    Node (int k, int v) {
        this.k = k;
        this.v = v;
        this.freq = 1;
    }

    Node () {
        this(-1, -1);
    }

}

class DLL {
    Node head, tail;
    int size;

    DLL () {
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
        size = 0;
    }

    void add(Node node) {
        
        Node tailPrev = tail.prev;

        tailPrev.next = node;
        node.prev = tailPrev;
        tail.prev = node;
        node.next = tail;
        size++;
    }

    void remove(Node node) {

        node.prev.next = node.next;
        node.next.prev = node.prev;
        size--;
    }

    Node evictHeadNext() {
        Node nodeToEvict = head.next;
        remove(nodeToEvict);
        return nodeToEvict;
    }

    boolean isEmpty() {
        return size == 0;
    }

}