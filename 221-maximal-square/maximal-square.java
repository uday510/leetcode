class Solution {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m][n];
        int maximalSquare = 0;

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                char ch = matrix[i][j];
                if (ch == '0') continue;
                
                dp[i][j] = 1;
                if (i > 0 && j > 0) {
                    dp[i][j] += Math.min(
                    dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1]));
                }

                maximalSquare = Math.max(maximalSquare, dp[i][j]);
            }
        }

        return maximalSquare * maximalSquare;
    }
}