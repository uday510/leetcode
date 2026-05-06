class Solution {

    private int[][] grid;
    private int n, m;
    private int[][][] dp;

    public int cherryPickup(int[][] grid) {

        this.grid = grid;
        this.n = grid.length;
        this.m = grid[0].length;
        this.dp = new int[n][m][m];

        for (int[][] twoD : dp) 
            for (int[] row : twoD)
                Arrays.fill(row, -1);


        return dfs(0, 0, m - 1);   
    }

    private int dfs(int x, int y1, int y2) {

        if (
            y1 >= m || y2 >= m ||
            y1 < 0 || y2 < 0
        ) {
            return Integer.MIN_VALUE;
        }

        if (x == n - 1) {
            if (y1 == y2) return grid[x][y1];
            return grid[x][y1] + grid[x][y2];
        }

        if (dp[x][y1][y2] != -1) {
            return dp[x][y1][y2];
        }

        int cur = grid[x][y1];
        if (y1 != y2) cur += grid[x][y2];

        int nxt = 0;

        for (int y3 = y1 - 1; y3 <= y1 + 1; y3++) {
            for (int y4 = y2 - 1; y4 <= y2 + 1; y4++) {
                nxt = Math.max(nxt, dfs(x + 1, y3, y4));
            }
        }

        return dp[x][y1][y2] = cur + nxt;
    }
}