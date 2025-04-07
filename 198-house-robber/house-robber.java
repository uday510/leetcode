class Solution {
    int[] nums;
    int[] dp;
    public int rob(int[] nums) {
        this.nums = nums;
        this.dp = new int[nums.length];
        Arrays.fill(dp, -1);
        return dfs(0);
    }
    private int dfs(int idx) {
        if (idx >= nums.length) return 0;
        if (dp[idx] != -1) return dp[idx];

        int rob1 = dfs(idx + 1);
        int rob2 = nums[idx] + dfs(idx + 2);
        return dp[idx] = Math.max(rob1, rob2);
    }
}