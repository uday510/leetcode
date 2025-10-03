class Solution {

    int n, m;
    int[][] grid, dp;

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        n = obstacleGrid.length;
        m = obstacleGrid[0].length;
        grid = obstacleGrid;
        dp = new int[n][m];

        for (int[] row : dp) Arrays.fill(row, -1);

        return dfs(0, 0);
    }

    private int dfs(int i, int j) {
        if (i >= n || j >= m || grid[i][j] == 1) return 0;

        if (dp[i][j] != -1) return dp[i][j];

        if (i == n - 1 && j == m - 1) return grid[i][j] == 1 ? 0 : 1;

        return dp[i][j] = dfs(i + 1, j) + dfs(i, j + 1);
    }
}