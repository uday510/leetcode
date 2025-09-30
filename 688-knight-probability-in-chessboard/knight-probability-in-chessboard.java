class Solution {

    private final int[][] dirs = {{-2, -1}, {-2, 1}, {-1, -2}, {-1, 2}, {1, -2}, {1, 2}, {2, 1}, {2, -1}};
    double[][][] dp;
    int n;

    public double knightProbability(int n, int k, int row, int column) {
        this.n = n;
        dp = new double[n][n][k + 1];
        for (double[][] d : dp) {
            for (double[] r : d) {
                Arrays.fill(r, -1);
            }
        }
            
        return dfs(row, column, k);
    }
    private double dfs(int x, int y, int k) {
        if (k == 0) return 1;

        if (dp[x][y][k] != -1) return dp[x][y][k];

        double cur = 0;

        for (int[] dir : dirs) {
            int nx = dir[0] + x, ny = dir[1] + y;

            if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                cur += dfs(nx, ny, k - 1);
            }
        }

        return dp[x][y][k] = cur / 8.0;
    }
}