class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m][n];

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                dp[i][j] = matrix[i][j];
                if (i > 0 && j > 0) {
                   if (j + 1 < n) dp[i][j] += Math.min(dp[i - 1][j], Math.min(dp[i - 1][j - 1], dp[i - 1][j + 1]));
                   else dp[i][j] += Math.min(dp[i - 1][j], dp[i - 1][j - 1]);
                }
                else if (i > 0) {
                    dp[i][j] += Math.min(dp[i - 1][j], dp[i - 1][j + 1]);
                }
            }            
        }
        
        return Arrays.stream(dp[m - 1]).min().getAsInt();
    }
}

/**

[
    [100,-42,-46,-41]
    [31,97,10,-10]
    [-58,-51,82,89]
    [51,81,69,-51]]



 */