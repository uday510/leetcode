class Solution {

    int m, n;
    int[][] dp;
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        m = obstacleGrid.length;
        n = obstacleGrid[0].length;
        dp = new int[m][n];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return dfs(0, 0, obstacleGrid);
    }

    private int dfs(int i, int j, int[][] grid) {
        if (i >= m || j >= n) return 0;

        if (i == m - 1 && j == n - 1) {
            if (grid[i][j] == 0) return 1;
            return 0;
        }

        if (grid[i][j] == 1) return 0;

        if (dp[i][j] != -1) return dp[i][j];

        return dp[i][j] = dfs(i + 1, j, grid) + dfs(i, j + 1, grid);
    }
}