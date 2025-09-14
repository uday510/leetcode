class Solution {
    final static int[][] dirs = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    int n, m;
    char[][] grid;
    public int numIslands(char[][] grid) {
        int islands = 0;
        n = grid.length;
        m = grid[0].length;
        this.grid = grid;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1') {
                    islands++;
                    dfs(i, j);
                }
            }
        }


        return islands;
    }

    private void dfs(int i, int j) {
        if (i < 0 || i >= n || j < 0 || j >= m || grid[i][j] != '1') return;

        grid[i][j] = '0';

        for (int[] dir : dirs) {
            int dx = dir[0] + i;
            int dy = dir[1] + j;

            dfs(dx, dy);
        }
    }
}