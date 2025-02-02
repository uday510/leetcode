class Solution {
    public int minPathSum(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int[][] dp = new int[rows][cols];

        for (int row = 0; row < rows; ++row) {
            for (int col = 0; col < cols; ++col) {
                dp[row][col] += grid[row][col];

                if (row > 0 && col > 0) {
                    dp[row][col] += Math.min(dp[row - 1][col], dp[row][col - 1]);
                } else if (row > 0) {
                    dp[row][col] += dp[row - 1][col];
                } else if (col > 0) {
                    dp[row][col] += dp[row][col - 1];
                }
            }
        }

        return dp[rows - 1][cols - 1];
    }
}

/**

[1, 2, 3]
[4, 5, 6]

[1, 3]
[1, 1]

*/