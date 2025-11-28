class NumMatrix {

    private int[][] dp;

    public NumMatrix(int[][] A) {
        int n = A.length, m = A[0].length;
        dp = new int[n + 1][m + 1];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dp[i + 1][j + 1] = A[i][j] + dp[i + 1][j] + dp[i][j + 1] - dp[i][j];
            }
        } 
    }
    
    public int sumRegion(int r1, int c1, int r2, int c2) {
        return dp[r2 + 1][c2 + 1] - dp[r2 + 1][c1] - dp[r1][c2 + 1] + dp[r1][c1];
    }
}
