class Solution {
    int[][] dp;
    public int climbStairs(int n) {
        dp = new int[n+1][n+1];

        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }

        return dfs(1, n);
    }
    private int dfs(int i, int n) {
        if (i >= n) {
            return 1;
        }

        if (dp[i][n] != -1) {
            return dp[i][n];
        }

        return dp[i][n] = dfs(i + 1, n) + dfs(i + 2, n);
    }
}