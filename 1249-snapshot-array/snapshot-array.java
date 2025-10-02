class SnapshotArray {
    List<int[]>[] records;
    int snapId;

    public SnapshotArray(int length) {
        records = new ArrayList[length];
        snapId = 0;
        for (int i = 0; i < length; i++) {
            records[i] = new ArrayList<>();
            records[i].add(new int[]{0, 0});
        }
    }

    public void set(int index, int val) {
        if (records[index].get(records[index].size() - 1)[0] == snapId) {
            records[index].get(records[index].size() - 1)[1] = val;
        } else {
            records[index].add(new int[]{snapId, val});
        }
    }

    public int snap() {
        return snapId++;
    }

    public int get(int index, int targetSnap) {
        List<int[]> list = records[index];
        int l = 0, r = list.size() - 1, ans = 0;

        while (l <= r) {
            int mid = (l + r) / 2;
            if (list.get(mid)[0] <= targetSnap) {
                ans = list.get(mid)[1];
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return ans;
    }
}