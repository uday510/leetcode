class Solution {
    public int maximalSquare(char[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        int[][] dp = new int[n][m];
        int maxLen = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                char ch = matrix[i][j];
                if (ch == '0') continue;

                int dia = 0, left = 0, up = 0;
                if (i > 0 && j > 0) dia = dp[i - 1][j - 1];
                if (i > 0) up = dp[i - 1][j];
                if (j > 0) left = dp[i][j - 1];

                dp[i][j] = 1 + Math.min(dia, Math.min(left, up));
                maxLen = Math.max(maxLen, dp[i][j]);
            }
        }


        return maxLen * maxLen;
    }
}