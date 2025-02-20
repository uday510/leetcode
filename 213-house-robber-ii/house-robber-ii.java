class Solution {
    int[] nums;
    int[] dp;
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        this.nums = nums;
        this.dp = new int[nums.length];
        Arrays.fill(dp, -1);

        int st0 = dfs(0, nums.length - 1);
        Arrays.fill(dp, -1);
        int st1 = dfs(1, nums.length);

        return Math.max(st0, st1);
    }

    private int dfs(int idx, int len) {
        if (idx >= len) {
            return 0;
        }

        if (dp[idx] != -1) {
            return dp[idx];
        }

        int pick = nums[idx] + dfs(idx + 2, len);
        int dont = dfs(idx + 1, len);

        return dp[idx] = Math.max(pick, dont);
    }
}