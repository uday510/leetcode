class MyHashMap {

    private static final int DEFAULT_CAPACITY = 16;
    private static final double LOAD_FACTOR = 0.75;

    private LinkedList<Entry>[] buckets;
    private int size;

    public MyHashMap() {
        buckets = new LinkedList[DEFAULT_CAPACITY];
        size = 0;
    }
    
    public void put(int key, int value) {
        if ((size + 1) > LOAD_FACTOR * buckets.length) {
            resize();
        }

        int index = indexFor(key);

        if (buckets[index] == null) {
            buckets[index] = new LinkedList<Entry>();
            buckets[index].add(new Entry(key, value));
        }

        for (var e : buckets[index]) {
            if (e.k == key) {
                e.v = value;
                return;
            }
        }
        
        buckets[index].add(new Entry(key, value));
        size++;
    }
    
    public int get(int key) {
        int idx = indexFor(key);
        var b = buckets[idx];
        if (b == null) return -1;

        for (var e : b) {
            if (e.k == key) return e.v;
        }


        return -1;
    }
    
    public void remove(int key) {
        int index = indexFor(key);
        var b = buckets[index];

        if (b == null) return;

        Iterator<Entry> it = b.iterator();
        while (it.hasNext()) {
            if (it.next().k == key) {
                it.remove();
                size--;
                return;
            }
        }
    }

    private int indexFor(int key) {
        return Math.floorMod(key, buckets.length);
    }

    private void resize() {
        LinkedList<Entry>[] old = buckets;
        LinkedList<Entry>[] newBuckets = new LinkedList[old.length * 2];


        for (var o : old) {
            if (o == null) continue;
            for (Entry e : o) {
                int newBucketIndexForEntry = Math.floorMod(e.k, newBuckets.length);
                if (newBuckets[newBucketIndexForEntry] == null) newBuckets[newBucketIndexForEntry] = new LinkedList<Entry>();
                newBuckets[newBucketIndexForEntry].add(e);
            }
        }
        
        buckets = newBuckets;
    }
}

class Entry {
    int k, v;

    Entry(int k, int v) {
        this.k = k;
        this.v = v;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */