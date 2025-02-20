class Solution {
    public int rob(int[] nums) {
        int t1 = 0;
        int t2 = nums[0];

        for (int idx = 1; idx < nums.length; ++idx) {
            int next = Math.max(t1 + nums[idx], t2);
            t1 = t2;
            t2 = next;
        }

        return Math.max(t1, t2);
    }
}