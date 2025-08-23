class Solution {
    List<Integer> lis;
    public int lengthOfLIS(int[] nums) {
        lis = new ArrayList<>();
        int n = nums.length;

        for (int i = 0; i < n; ++i) {
            int idx = bs(nums[i]);
            if (idx == lis.size()) lis.add(nums[i]);
            lis.set(idx, nums[i]);
        }

        return lis.size();
    }
    private int bs(int target) {
        int l = 0, r = lis.size();

        while (l < r) {
            int m =  l + r >> 1;

            if (lis.get(m) < target) l = m + 1;
            else r = m;
        }

        return l;
    }
}