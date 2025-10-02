public class SnapshotArray {

    int snapId;
    List<Pair>[] records;

    public SnapshotArray(int length) {
        snapId = 0;
        records = new ArrayList[length];

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
        int res = - 1;
        
        while (l < r) {
            int m = (l + r) >> 1;
                
            Pair p = record.get(m);
            if (p.snapId <= snap_id) {
                res = p.val;
                l = m + 1;
            } else {
                r = m;
            }
        }
        
        return res;
    }

    class Pair {
        int snapId;
        int val;

        public Pair(int snapId, int val) {
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