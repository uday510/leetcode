class SnapshotArray {
    private List<Node>[] arr;
    private int snapId;

    public SnapshotArray(int n) {
        arr = new ArrayList[n];
        snapId = 0;

        for (int i = 0; i < n; i++) {
            arr[i] = new ArrayList<>();
        }
    }

    
    public void set(int index, int val) {
        var cur = arr[index];

        if (cur.isEmpty() || cur.getLast().snapId != snapId) cur.add(new Node(snapId, val));
        else cur.getLast().val = val;
    }
    
    public int snap() {
        return snapId++;
    }
    
    public int get(int index, int snap_id) {
        var cur = arr[index];

        int l = 0, r = cur.size();
        int res = 0;

        while (l < r) {
            int m = l + ((r - l) >> 1);

            if (cur.get(m).snapId <= snap_id) {
                res = cur.get(m).val;
                l = m + 1;
            } else {
                r = m;
            }
        }

        return res;
    }
}

class Node {
    int snapId, val;
    Node (int snapId, int val) {
        this.snapId = snapId;
        this.val = val;
    }
}