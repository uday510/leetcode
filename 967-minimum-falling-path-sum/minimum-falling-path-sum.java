class Solution {
    public int minFallingPathSum(int[][] matrix) {
        
        int n = matrix.length;
        int[][] dp = new int[n][n];
        int ans = (int) 1e9;

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                dp[i][j] = matrix[i][j];

                int min = (int) 1e9;

                if (i - 1 >= 0 && j >= 0) min = Math.min(min, dp[i - 1][j]);
                if (i - 1 >= 0 && j + 1 < n) min = Math.min(min, dp[i - 1][j + 1]);
                if (i - 1 >= 0 && j - 1 >= 0) min = Math.min(min, dp[i - 1][j - 1]);

                dp[i][j] += (min == (int) 1e9 ? 0 : min);

                if (i == n - 1) ans = Math.min(ans, dp[i][j]);
            }
        }

        return ans;
    }
}