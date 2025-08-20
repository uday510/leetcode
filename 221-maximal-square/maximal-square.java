class Solution {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m][n];
        int maximalSquare = 0;

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                char ch = matrix[i][j];
                if (ch == '0') continue;

                int diagonal = 0, left = 0, up = 0;
                if (i > 0) up = dp[i - 1][j];
                if (j > 0) left = dp[i][j - 1];
                if (i > 0 && j > 0) diagonal = dp[i - 1][j - 1];
                dp[i][j] = 1 + Math.min(up, Math.min(left, diagonal));
                maximalSquare = Math.max(maximalSquare, dp[i][j]);
            }
        }

        return maximalSquare * maximalSquare;
    }
}