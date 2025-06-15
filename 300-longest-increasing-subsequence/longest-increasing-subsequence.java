class Solution {
    int[][] dp;
    int n;
    public int lengthOfLIS(int[] nums) {
        n = nums.length;
        dp = new int[n + 1][n];
        for (int[] row : dp) Arrays.fill(row, -1);
        return dfs(-1, 0, nums);
    }

    private int dfs(int prev, int curr, int[] nums) {
        if (curr >= nums.length) return 0;

        if (dp[prev + 1][curr] != -1) return dp[prev + 1][curr];
        int skip = dfs(prev, curr + 1, nums);
        int take = 0;

        if (prev == -1 || nums[prev] < nums[curr]) {
            take = 1 + dfs (curr, curr + 1, nums);
        }

        return dp[prev + 1][curr] = Math.max(skip, take);
    }
}