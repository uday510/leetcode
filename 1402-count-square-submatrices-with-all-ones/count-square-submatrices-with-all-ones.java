class Solution {
    public int countSquares(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] dp = new int[rows][cols];
        int cnt = fill(dp, matrix);

        for (int i = 1; i < rows; ++i) {
            for (int j = 1; j < cols; ++j) {
                if (matrix[i][j] == 0) continue;
                dp[i][j] = 1 + Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1]));
                cnt += dp[i][j];
            }
        }
        return cnt;
    }

    private int fill(int[][] dp, int[][] matrix) {
        int cnt = matrix[0][0];
        dp[0][0] = matrix[0][0];

        for (int i = 1; i < dp.length; ++i)
            cnt += dp[i][0] = matrix[i][0];

        for (int j = 1; j < dp[0].length; ++j)
            cnt += dp[0][j] = matrix[0][j];

        return cnt;
    }
}
