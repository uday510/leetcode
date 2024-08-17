class Solution {
    private static final int INF = (int) 1e9;
    private Integer[][] dp;
    private int n;

    public int minFallingPathSum(int[][] matrix) {
        int min = INF;
        n = matrix.length;
        dp = new Integer[n][n];

        for (int col = 0; col < matrix[0].length; ++col) {
            min = Math.min(min, dfs(0, col, matrix));
        }
        return min;
    }
    private int dfs(int row, int col, int[][] matrix) {
        if (col < 0 || col >= n) 
            return INF;

        if (row == n)
            return 0;

        if (dp[row][col] != null)
            return dp[row][col];

        int t = matrix[row][col];
        int down = dfs(row + 1, col, matrix);
        int downLeft = dfs(row + 1, col - 1, matrix);
        int downRight = dfs(row + 1, col + 1, matrix);

        t += Math.min(down, Math.min(downLeft, downRight));

        return dp[row][col] = t;
    }
}