class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        int rob1 = nums[0];
        int rob2 = Math.max(nums[0], nums[1]);

        for (int idx = 2; idx < nums.length; ++idx) {
            int curr = Math.max(rob1 + nums[idx], rob2);
            rob1 = rob2;
            rob2 = curr;
        }

        return Math.max(rob1, rob2);
    }

}