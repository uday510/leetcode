class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] dp = new int[rows][cols];

        for (int row = 0; row < rows; ++row) {
            for (int col = 0; col < cols; ++col) {
                if (row == 0) {
                    dp[row][col] = matrix[row][col];
                } else if (col == 0) {
                    dp[row][col] = Math.min(dp[row - 1][col], dp[row - 1][col + 1]) + matrix[row][col];
                } else if (col == cols - 1) {
                    dp[row][col] = Math.min(dp[row - 1][col], dp[row - 1][col - 1]) + matrix[row][col];
                } else {
                    dp[row][col] = Math.min(dp[row - 1][col], Math.min(dp[row - 1][col - 1], dp[row - 1][col + 1])) + matrix[row][col];
                }

            }
        }

        int minFallingSum = Integer.MAX_VALUE;
        for (int col = 0; col < cols; ++col) {
            minFallingSum = Math.min(minFallingSum, dp[rows - 1][col]);
        }

        return minFallingSum;
    }
}