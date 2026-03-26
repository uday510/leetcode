import java.util.HashMap;
import java.util.Map;

class LFUCache {

    private final int capacity;
    private int minFreq;
    private final Map<Integer, Node> lfu;
    private final Map<Integer, DLL> frqMap;
    
    public LFUCache(int capacity) {
        this.capacity = capacity;
        minFreq = 0;
        lfu = new HashMap<>();
        frqMap = new HashMap<>();
    }

    public int get(int key) {
        Node node = lfu.get(key);
        if (node == null) return -1;
        
        updateFreq(node);
        return node.v;
    }

    public void put(int key, int value) {
        Node node = lfu.get(key);
        
        if (node != null) {
            node.v = value;
            updateFreq(node);
            return;
        }
        
        if (lfu.size() == capacity) {
            DLL minList = frqMap.get(minFreq);
            Node evicted = minList.evictHeadNext();
            if (evicted != null) lfu.remove(evicted.k);
        }
        
        node = new Node(key, value);

        minFreq = 1;

        lfu.put(node.k, node);
        frqMap.computeIfAbsent(minFreq, _ -> new DLL()).add(node);
        
    }
    
    private void updateFreq(Node node) {
        int oldFreq = node.frq;
        DLL oldList = frqMap.get(oldFreq);
        
        oldList.remove(node);
        
        if (oldList.isEmpty() && minFreq == oldFreq) {
            minFreq++;
        }
        
        frqMap.computeIfAbsent(++node.frq, _ -> new DLL()).add(node);
    }
}

class Node {
    Node prv, nxt;
    int k, v, frq;
    
    Node (int k, int v) {
        this.k = k;
        this.v = v;
        frq = 1;
    }
}

class DLL {
    
    Node head, tail;
    int sz;
    
    DLL () {
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        
        head.nxt = tail;
        tail.prv = head;
        
        sz = 0;
    }
    
    void add(Node node) {
        Node tailPrev = tail.prv;
        
        tailPrev.nxt = node;
        node.prv = tailPrev;
        
        node.nxt = tail;
        tail.prv = node;
        
        sz++;
    }
    
    Node evictHeadNext() {
        if (sz == 0) return null;
        Node nodeToBeEvicted = head.nxt;
        remove(nodeToBeEvicted);
        return nodeToBeEvicted;
    }
    
    public void remove(Node node) {
       node.prv.nxt = node.nxt;
       node.nxt.prv = node.prv;
       
       sz--;
    }

    boolean isEmpty() {
        return sz == 0;
    }
}
