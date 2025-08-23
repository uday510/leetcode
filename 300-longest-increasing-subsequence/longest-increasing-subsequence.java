class Solution {
    int[] nums;
    int n;
    int[][] dp;
    public int lengthOfLIS(int[] nums) {
        this.nums = nums;
        n = nums.length;
        dp = new int[n + 1][n];

        for (int[] row : dp) Arrays.fill(row, -1);
        return dfs(-1, 0);
    }
    private int dfs(int i, int j) {
        if (i >= n || j >= n) return 0;

        if (dp[i + 1][j] != -1) return dp[i + 1][j];

        int skip = dfs(i, j + 1);

        int take = 0;

        if (i == -1 || nums[i] < nums[j]) {
            take = 1 + dfs(j, j + 1);
        }
        
        return dp[i + 1][j] = Math.max(skip, take);
    }
}