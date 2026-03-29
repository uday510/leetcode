class LFUCache {

    private int capacity;
    private Map<Integer, Node> lfu;
    private Map<Integer, DLL> freqMap;
    private int min;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        freqMap = new HashMap<>();
        lfu = new HashMap<>();
        min = 0;
    }
    
    public int get(int key) {
        Node cur = lfu.get(key);

        if (cur == null) return -1;

        updateFreq(cur);

        return cur.v;
    }

    private void updateFreq(Node node) {
        if (node == null) return;

        int oldFreq = node.f;
        DLL oldDLL = freqMap.get(oldFreq);

        oldDLL.remove(node);

        if (oldDLL.isEmpty() && min == oldFreq) {
            min++;
        }

        freqMap.computeIfAbsent(++node.f, _ -> new DLL()).add(node);
    }
    
    public void put(int key, int value) {
        
        Node curNode = lfu.get(key);

        // exists, update value
        if (curNode != null) {
            curNode.v = value;
            updateFreq(curNode);
            return;
        }

        // reaches capacity
        if (lfu.size() == capacity) {
            DLL minList = freqMap.get(min);
            Node evicted = minList.evictHeadNext();
            if (evicted != null) lfu.remove(evicted.k);
        }

        curNode = new Node(key, value);
        
        min = 1;

        lfu.put(curNode.k, curNode);
        freqMap.computeIfAbsent(min, _ -> new DLL()).add(curNode);
    }

}

class Node {
    Node prev, next;
    int k, v, f;

    Node (int k, int v) {
        this.k = k;
        this.v = v;
        f = 1;
    }
}

class DLL {

    Node head, tail;
    int sz;

    DLL () {
        head = new Node(-1, -1);
        tail = new Node(-1, -1);

        head.next = tail;
        tail.prev = head;
        
        sz = 0;
    }

    void add(Node node) {
        
        Node tailPrev = tail.prev;

        tailPrev.next = node;
        node.prev = tailPrev;

        node.next = tail;
        tail.prev = node;

        sz++;
    }

    Node remove(Node node) {
        if (node == null) return null;

        node.prev.next = node.next;
        node.next.prev = node.prev;

        sz--;

        return node;
    }

    Node evictHeadNext() {
        if (sz == 0) return null;

        Node evicted = remove(head.next);

        return evicted;
    }

    boolean isEmpty() {
        return sz == 0;
    }

}