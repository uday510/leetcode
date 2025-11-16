class NumMatrix {

    private int[][] dp;

    public NumMatrix(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        dp = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dp[i][j] = matrix[i][j] 
                         + (i > 0 ? dp[i-1][j] : 0)
                         + (j > 0 ? dp[i][j-1] : 0)
                         - (i > 0 && j > 0 ? dp[i-1][j-1]: 0);
            }
        }
    }
    
    public int sumRegion(int r1, int c1, int r2, int c2) {
        int base = dp[r2][c2];
        int top = r1 > 0 ? dp[r1 - 1][c2] : 0;
        int left = c1 > 0 ? dp[r2][c1 - 1] : 0;
        int overlap = (r1 > 0 && c1 > 0 ? dp[r1 - 1][c1 - 1] : 0);

        return base - top - left + overlap;
    }
}