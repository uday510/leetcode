class Solution {
    public int lengthOfLIS(int[] nums) {
        
        int n = nums.length;
        List<Integer> lis = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            int cur = nums[i];

            int idx = bs(cur, lis);
            if (idx == lis.size()) lis.add(cur);
            lis.set(idx, cur);
        }

        return lis.size();
    }

    private int bs(int t, List<Integer> list) {
        int l = 0, r = list.size();

        while (l < r) {
            int m = l + ((r - l) >> 2);

            if (list.get(m) < t) l = m + 1;
            else r = m;
        }

        return l;
    }
}