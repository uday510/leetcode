class Solution {
    public int lengthOfLIS(int[] arr) {
        int n = arr.length;
        List<Integer> lis = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int idx = bs(arr[i], lis);
            if (idx == lis.size()) lis.add(arr[i]);
            lis.set(idx, arr[i]);
        }

        return lis.size();
    }
    private int bs(int val, List<Integer> list) {
        int l = 0, r = list.size();

        while (l < r) {
            int m = l + ((r - l) >> 1);
            
            if (list.get(m) < val) l = m + 1;
            else r = m;
        }

        return l;
    }
}