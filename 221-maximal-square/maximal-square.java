class Solution {
    public int maximalSquare(char[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] dp = new int[rows + 1][cols + 1];
        int maximum = 0;
        
        for (int row = 1; row <= rows; ++row) {
            for (int col = 1; col <= cols; ++col) {
                if (matrix[row - 1][col - 1] == '0') {
                    continue;
                }

                dp[row][col] = Math.min(dp[row - 1][col - 1],
                        Math.min(dp[row - 1][col], dp[row][col - 1])) + 1;

                maximum = Math.max(dp[row][col], maximum);
            }
        }
        
        return maximum * maximum;
    }
}