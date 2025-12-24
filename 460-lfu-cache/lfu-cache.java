class LFUCache {

    Map<Integer, Node> lfu;
    Map<Integer, DLL> freqMap;
    int capacity, minFreq;

    public LFUCache(int capacity) {
        lfu = new HashMap<>();
        freqMap = new HashMap<>();
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
            DLL dll = freqMap.get(minFreq);
            Node nodeToEvict = dll.evictHeadNext();
            lfu.remove(nodeToEvict.k);
        }

        node = new Node(key, value);

        lfu.put(key, node);
        freqMap.computeIfAbsent(1, _ -> new DLL()).add(node);
        minFreq = 1;
    }

    private void updateFreq(Node node) {
        int oldFreq = node.freq;

        DLL oldList = freqMap.get(oldFreq);

        oldList.remove(node);
        if (oldFreq == minFreq && oldList.isEmpty()) {
            minFreq++;
        }

        node.freq++;
        freqMap.computeIfAbsent(node.freq, _ -> new DLL()).add(node);
    }

}

class Node {
    Node prev, next;

    int k, v, freq;

    Node (int k, int v) {
        this.k = k;
        this.v = v;
        freq = 1;
    }

}

class DLL {
    Node head, tail;
    int size;

    DLL () {
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        size = 0;

        head.next = tail;
        tail.prev = head;
    }

    void add(Node node) {

        Node tailPrev = tail.prev;

        tailPrev.next = node;
        node.prev = tailPrev;

        tail.prev = node;
        node.next = tail;

        size++;
    }

    Node remove(Node node) {

        node.prev.next = node.next;
        node.next.prev = node.prev;
        size--;

        return node;
    }

    Node evictHeadNext() {
        Node node = head.next;
        remove(node);

        return node;
    }

    boolean isEmpty() {
        return size == 0;
    }
}

