class LFUCache {

    private final int capacity;
    private int minFreq;
    private final Map<Integer, Node> lfu;
    private final Map<Integer, DLL> freqMap;
    
    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.minFreq = 0;
        this.lfu = new HashMap<>();
        this.freqMap = new HashMap<>();
    }

    public int get(int key) {
        Node node = lfu.get(key);
        if (node == null) return -1;
        
        updateFreq(node);
        
        return node.value;
    }
    
    private void updateFreq(Node node) {
        int oldFreq = node.freq;
        DLL oldList = freqMap.get(oldFreq);
        oldList.remove(node);
        
        if (oldList.isEmpty() && minFreq == oldFreq) {
            minFreq++;
        }
        
        node.freq++;
        freqMap.computeIfAbsent(node.freq , _ -> new DLL()).add(node);
    }

    public void put(int key, int value) {
        if (capacity == 0) return;
        
        Node node = lfu.get(key);

        if (node != null) {
            node.value = value;
            updateFreq(node);
            return;
        }
        
        if (lfu.size() == capacity) {
            DLL minList = freqMap.get(minFreq);
            Node evicted = minList.removeHead();
            if (evicted != null) lfu.remove(evicted.key);
        }
        
        node = new Node(key, value);

        lfu.put(node.key, node);
        freqMap.computeIfAbsent(1, _ -> new DLL()).add(node);
        minFreq = 1;
    }

}

class Node {
    int key, value, freq;
    Node prev, next;

    Node (int key, int value) {
        this.key = key;
        this.value = value;
        this.freq = 1;
    }

}

class DLL {
    Node head, tail;
    int size;

    DLL () {
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
        size = 0;
    }

    void add (Node node) {
        Node tailPrev = tail.prev;
        
        node.prev = tailPrev;
        tailPrev.next = node;

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

    Node removeHead() {
        if (size == 0) return null;
        Node node = head.next;
        remove(node);
        return node;
    }

    boolean isEmpty() {
        return size == 0;
    }


}