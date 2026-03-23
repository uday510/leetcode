class Solution {
    private static final int MOD = (int) 1e9 + 7;
    private static final Long MIN = Long.MIN_VALUE;
    private static final Long MAX = Long.MAX_VALUE;

    private int[][] grid;
    private int n, m, mx;
    private long[][][] dp;
    private boolean[][] vis;

    public int maxProductPath(int[][] grid) {
        this.grid = grid;
        n = grid.length;
        m = grid[0].length;
        mx = -1;
        dp = new long[n][m][2];
        vis = new boolean[n][m];

        long[] res = dfs(0, 0);
        return res[0] < 0 ? -1 : (int)(res[0] % MOD);
    }

    private long[] dfs(int i, int j) {
        if (i >= n || j >= m) return new long[] {MIN, MAX};

        if (vis[i][j]) return dp[i][j];

        if (i == n - 1 && j == m - 1) {
            return dp[i][j] = new long[] {grid[i][j], grid[i][j]};
        }

        vis[i][j] = true;
        
        long[] d = dfs(i + 1, j);
        long[] r = dfs(i, j + 1);

        long cur = grid[i][j];

        long mn = MAX, mx = MIN;

        if (d[0] != MIN) {
            mx = Math.max(mx, d[0] * cur);
            mn = Math.min(mn, d[0] * cur);
        }

        if (d[1] != MAX) {
            mx = Math.max(mx, d[1] * cur);
            mn = Math.min(mn, d[1] * cur);
        }

        if (r[0] != MIN) {
            mx = Math.max(mx, r[0] * cur);
            mn = Math.min(mn, r[0] * cur);
        }

        if (r[1] != MAX) {
            mx = Math.max(mx, r[1] * cur);
            mn = Math.min(mn, r[1] * cur);
        }

        return dp[i][j] = new long[]{mx, mn};
    }
}