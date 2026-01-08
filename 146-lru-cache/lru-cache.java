class LRUCache {


    Map<Integer, Node> lru;
    Node head, tail;
    int capacity;

    public LRUCache(int capacity) {
        lru = new HashMap<>();
        head = new Node(-1, -1);
        tail = new Node(-1, -1);

        head.next = tail;
        tail.prev = head;
        this.capacity = capacity;    
    }
    
    public int get(int key) {
        
        Node node = lru.get(key);

        if (node == null) return -1;

        remove(node);
        add(node);

        return node.v;
    }
    
    public void put(int key, int value) {

      Node node = lru.get(key) ;

      if (node != null) {
        remove(node);
        node.v = value;
      } else {
        if (lru.size() == capacity) {
            remove(head.next);
        }
        node = new Node(key, value);
      }

      add(node);

    }

    private void add(Node node) {
        lru.put(node.k, node);

        Node tailPrev = tail.prev;

        tailPrev.next = node;
        node.prev = tailPrev;

        tail.prev = node;
        node.next = tail;
    }

    private void remove(Node node) {
        lru.remove(node.k);

        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
}

class Node {
    Node prev, next;

    int k, v;

    Node (int k, int v) {
        this.k = k;
        this.v = v;
    }

}