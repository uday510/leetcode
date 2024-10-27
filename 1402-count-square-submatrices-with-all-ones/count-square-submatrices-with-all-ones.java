class Solution {
    public int countSquares(int[][] matrix) {
        int cols = matrix[0].length;
        int rows = matrix.length;
        int[][] dp = new int[rows][cols];
        int count = 0;
        for(int i = 0; i < rows; i++) {
            dp[i][0] = matrix[i][0];
            count += dp[i][0];
        }
        for(int i = 0; i < cols; i++) {
            dp[0][i] = matrix[0][i];
            count += dp[0][i];
        }
        count -= dp[0][0];
        for(int i = 1; i < rows; i++) {
            for(int j = 1; j < cols; j++) {
                if(matrix[i][j] == 1) {
                    dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1])) + 1;
                    count += dp[i][j];
                }
            }
        }
        return count;
    }
}