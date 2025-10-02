class MyHashMap {

    private static final int DEFAULT_CAPACITY = 16;
    private static final double LOAD_FACTOR = 0.75;

    private LinkedList<Entry>[] buckets = new LinkedList[DEFAULT_CAPACITY];
    private int size = 0;

    public MyHashMap() {}

    public void put(int key, int value) {
        if ( (size + 1) > LOAD_FACTOR * buckets.length) {
            resize();
        }

        int index = indexFor(key);
        if (buckets[index] == null) buckets[index] = new LinkedList<>();

        for (Entry e : buckets[index]) {
            if (e.k == key) {
                e.v = value;
                return;
            }
        }

        buckets[index].add(new Entry(key, value));
        size++;
    }

    public int get(int key) {
        int index = indexFor(key);
        var bucket = buckets[index];
        if (bucket == null) return -1;
        
        for (Entry e : bucket) {
            if (e.k == key) return e.v;
        }
        
        return -1;
    }

    public void remove(int key) {
        int index = indexFor(key);
        var bucket = buckets[index];
        if (bucket == null) return;

        Iterator<Entry> it = bucket.iterator();
        while (it.hasNext()) {
            if (it.next().k == key) {
                it.remove();
                size--;
                return;
            }
        }
    }

    private void resize() {
        LinkedList<Entry>[] oldBuckets = buckets;
        LinkedList<Entry>[] newBuckets = new LinkedList[oldBuckets.length * 2];

        for (LinkedList<Entry> oldBucket : oldBuckets) {
            if (oldBucket == null) continue;
            for (Entry e : oldBucket) {
                int idx = Math.floorMod(e.k, newBuckets.length);
                if (newBuckets[idx] == null) newBuckets[idx] = new LinkedList<>();
                newBuckets[idx].add(e);
            }
        }
        
        buckets = newBuckets;
    }

    private int indexFor(int key) {
        return Math.floorMod(key, buckets.length);
    }

    class Entry {
        int k, v;

        Entry(int k, int v) { this.k = k; this.v = v; };
    }
}
