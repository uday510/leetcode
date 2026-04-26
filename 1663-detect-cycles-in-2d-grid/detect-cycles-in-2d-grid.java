class Solution {

    private int[][] DIRs = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    private char[][] grid;
    private int n, m;
    private boolean[][] vis;

    public boolean containsCycle(char[][] grid) {
        m = grid.length;
        n = grid[0].length;
        vis = new boolean[m][n];
        this.grid = grid;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!vis[i][j] && dfs(i, j, -1, -1)) return true;
            }
        }

        return false;
    }

    private boolean dfs(int i, int j, int pi, int pj) {

        if (vis[i][j]) return true;

        vis[i][j] = true;

        for (int[] d : DIRs) {
            int x = d[0] + i;
            int y = d[1] + j;

            if (x < 0 || x >= m || y < 0 || y >= n) continue;

            if (grid[i][j] != grid[x][y]) continue;

            if (x == pi && y == pj) continue;
           
           if (dfs(x, y, i, j)) return true;

        }

        return false;
    }

}

/**

a a
a a

 */