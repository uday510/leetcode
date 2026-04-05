class SnapshotArray {

    private List<Node>[] arr;
    private int id;

    public SnapshotArray(int len) {
        arr = new ArrayList[len];
        id = 0;

        for (int i = 0; i < len; i++) {
            arr[i] = new ArrayList<>();
            arr[i].add(new Node(0, 0) );
        }
    }
    
    public void set(int index, int val) {
        var cur = arr[index];

        if (cur.getLast().id == id) cur.getLast().val = val;
        else cur.add(new Node(id, val));
        
    }
    
    public int snap() {
        return id++;
    }
    
    public int get(int index, int snap_id) {
        var cur = arr[index];

        int l = 0, r = cur.size();
        int res = -1;

        while (l < r) {
            int m = l + (r - l) / 2;

            if (cur.get(m).id <= snap_id) {
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
    int id;
    int val;

    Node (int id, int val) {
        this.id = id;
        this.val = val;
    }
}

