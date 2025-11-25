class Solution {
    
    int n, m;
    int[][] G, dp;

    public int uniquePathsWithObstacles(int[][] O) {
        n = O.length;
        m = O[0].length;
        G = O;
        dp = new int[n][m];

        if (O[n - 1][m - 1] == 1) return 0;

        for (int[] row : dp) Arrays.fill(row, -1);

        return dfs(0, 0);
    }

    private int dfs(int i, int j) {
        if (i >= n || j >= m || G[i][j] == 1) return 0;

        if (dp[i][j] != -1) return dp[i][j];

        if (i == n - 1 && j == m - 1) return 1;

        return dp[i][j] = dfs(i + 1, j) + dfs(i, j + 1);
    }
}