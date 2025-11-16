class NumMatrix {

    private int[][] dp;

    public NumMatrix(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        dp = new int[n + 1][m + 1];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dp[i + 1][j + 1] = matrix[i][j] + dp[i + 1][j] + dp[i][j + 1] - dp[i][j];
            }
        }
    }
    
    public int sumRegion(int r1, int c1, int r2, int c2) {
        int base = dp[r2 + 1][c2 + 1];
        int top = dp[r1][c2 + 1];
        int left = dp[r2 + 1][c1];

        int overlap = dp[r1][c1];

        return base - top - left + overlap;
    }
}