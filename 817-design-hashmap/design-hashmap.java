import java.util.ArrayList;

class MyHashMap {

    private static final double LOAD_FACTOR = 0.75;
    private ArrayList<Entry<Integer, Integer>>[] buckets;
    private int size;

    public MyHashMap() {
        buckets = new ArrayList[2069];
        size = 0;
    }

    public void put(int key, int value) {

        if ( (double) size / buckets.length >= LOAD_FACTOR) {
            resize();
        }
        
        int index = getIndex(key);
        if (buckets[index] == null) {
            buckets[index] = new ArrayList<>();
        }
        
        for (var entry : buckets[index]) {
            if (entry.k == key) {
                entry.v = value;
                return;
            }
        }
        
        buckets[index].add(new Entry<>(key, value));
        size++;
    }

    public int get(int key) {
        int index = getIndex(key);
        int value = -1;

        if (buckets[index] == null) return value;

        for (var entry : buckets[index]) {
            if (entry.k == key) {
                value = entry.v;
                break;
            }
        }

        return value;
    }

    public void remove(int key) {
        int index = getIndex(key);

        if (buckets[index] == null) return;

        buckets[index].removeIf(e -> e.k == key);
        size--;
    }

    private int getIndex(int key) {
        return key % buckets.length;
    }

    private void resize() {
        var oldBuckets = buckets;
        buckets = new ArrayList[oldBuckets.length * 2];

        for (var oldBucket : oldBuckets) {
            if (oldBucket == null) continue;

            for (var oldBucketEntry : oldBucket) {
                put(oldBucketEntry.k, oldBucketEntry.v);
            }
        }

    }

    class Entry<K, V> {
        K k;
        V v;

        Entry(K k, V v) {
            this.k = k;
            this.v = v;
        }
    }

}