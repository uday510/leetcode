class MyHashMap {

    private static double LOAD_FACTOR = 0.75;
    private LinkedList<Entry>[] buckets;
    private int size;

    public MyHashMap() {
        buckets = new LinkedList[16];
        size = 0;
    }

    private int getIndex(int key) {
        return key % buckets.length;
    }

    private static class Entry {
        int key, value;

        Entry(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    
    public void put(int key, int value) {
        if ((double) size / buckets.length > LOAD_FACTOR) {
            resize();
        }

        int index = getIndex(key);
        if (buckets[index] == null) {
            buckets[index] = new LinkedList<>();
        }

        for (var entry : buckets[index]) {
            if (entry.key == key) {
                entry.value = value;
                return;
            }
        }

        buckets[index].add(new Entry(key, value));
        size++;

    }
    
    public int get(int key) {
        int index = getIndex(key);
        int value = -1;

        if (buckets[index] == null) {
            return value;
        }

        for (var entry : buckets[index]) {
            if (entry.key == key) {
                value = entry.value;
                break;
            }
        }

        return value;
    }
    
    public void remove(int key) {
        int index = getIndex(key);

        if (buckets[index] == null) {
            return;
        }

        buckets[index].removeIf(entry -> entry.key == key);
        size--;

    }

    private void resize() {
        LinkedList<Entry>[] old = buckets;
        buckets = new LinkedList[old.length * 2];
        size = 0;

        for (var bucket: old) {
            if (bucket == null) 
                continue;
                
            for (var entry : bucket) {
                put(entry.key, entry.value);
            }
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */