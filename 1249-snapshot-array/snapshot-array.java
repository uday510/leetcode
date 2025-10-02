class SnapshotArray {
    
    List<Pair>[] records;
    int snapId;

    public SnapshotArray(int length) {
        records = new ArrayList[length];
        snapId = 0;

        for (int i = 0; i < length; i++) {
            records[i] = new ArrayList<>();
            records[i].add(new Pair(0, 0));
        }
    }

    public void set(int index, int val) {
        List<Pair> record = records[index];

        if (record.getLast().snapId == snapId) {
            record.getLast().val = val;
        } else {
            record.add(new Pair(snapId, val));
        }
    }
    
    public int snap() {
        return snapId++;
    }
    
    public int get(int index, int snap_id) {
        List<Pair> record = records[index];
        int l = 0, r = record.size();
        int res = -1;

        while (l < r) {
            int m = (l + r) >> 1;
            Pair pair = record.get(m);

            if (pair.snapId <= snap_id) { l = m + 1; res = pair.val; }
            else r = m;
        }

        return res;
    }

    private class Pair {
        int snapId, val;

        Pair(int snapId, int val) {
            this.snapId = snapId;
            this.val = val;
        }
    }
}

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */