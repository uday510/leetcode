class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[m][n];

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (i == 0) dp[i][j] = grid[i][j] + (j > 0 ? dp[i][j - 1] : 0);
                else if (j == 0) dp[i][j] = grid[i][j] + (i > 0 ? dp[i - 1][j] : 0);
                else {
                    dp[i][j] = grid[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m - 1][n - 1];
    }
}