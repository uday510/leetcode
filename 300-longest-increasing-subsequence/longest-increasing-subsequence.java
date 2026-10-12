class Solution {
    public int lengthOfLIS(int[] arr) {
        int n = arr.length;

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int cur = arr[i];

            int idx = bs(cur, list);
            if (idx == list.size()) list.add(cur);
            list.set(idx, cur);
        }

        return list.size();
    }

    private int bs (int t, List<Integer> list) {
        int l = 0, r = list.size();

        while (l < r) {
            int m = l + ( (r - l) >> 1);

            if (list.get(m) < t) l = m + 1;
            else r = m;
        }

        return l;
    }
}