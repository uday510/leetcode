class Solution {

    int rows;
    int cols;
    int[][] dp;

    public int minPathSum(int[][] grid) {
        rows = grid.length;
        cols = grid[0].length;
        dp = new int[rows][cols];

        for (int row = 0; row < rows; ++row) {
            for (int col = 0; col < cols; ++col) {
                dp[row][col] = grid[row][col] + getMin(row, col, grid);
            }
        }
        return dp[rows - 1][cols - 1];
    }

    private int getMin(int row, int col, int[][] grid) {
        int curr = 0;
        if (row > 0 && col > 0) {
            curr = Math.min(dp[row - 1][col], dp[row][col - 1]);
        } else if (row > 0) {
            curr = dp[row - 1][col];
        } else if (col > 0) {
            curr = dp[row][col - 1];
        }

        return curr;
    }
}
