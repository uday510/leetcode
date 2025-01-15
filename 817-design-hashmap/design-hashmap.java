import java.util.LinkedList;

class MyHashMap {
    private static final double LOAD_FACTOR = 0.75;
    private LinkedList<Entry>[] buckets;
    private int size;

    private static class Entry {
        int key, value;

        Entry(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public MyHashMap() {
        buckets = new LinkedList[16]; // Start small
        size = 0;
    }

    private int getBucketIndex(int key) {
        return key % buckets.length;
    }

    public void put(int key, int value) {
        if ((double) size / buckets.length > LOAD_FACTOR) {
            resize();
        }

        int index = getBucketIndex(key);
        if (buckets[index] == null) {
            buckets[index] = new LinkedList<>();
        }

        for (Entry entry : buckets[index]) {
            if (entry.key == key) {
                entry.value = value; // Update if key exists
                return;
            }
        }

        buckets[index].add(new Entry(key, value));
        size++;
    }

    public int get(int key) {
        int index = getBucketIndex(key);
        if (buckets[index] == null) return -1;

        for (Entry entry : buckets[index]) {
            if (entry.key == key) return entry.value;
        }

        return -1;
    }

    public void remove(int key) {
        int index = getBucketIndex(key);
        if (buckets[index] != null) {
            buckets[index].removeIf(entry -> entry.key == key);
            size--;
        }
    }

    private void resize() {
        LinkedList<Entry>[] oldBuckets = buckets;
        buckets = new LinkedList[oldBuckets.length * 2];
        size = 0;

        for (LinkedList<Entry> bucket : oldBuckets) {
            if (bucket != null) {
                for (Entry entry : bucket) {
                    put(entry.key, entry.value);
                }
            }
        }
    }
}