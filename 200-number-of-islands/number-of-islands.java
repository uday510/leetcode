class Solution {
    boolean[][] vis;
    int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};
    int m;
    int n;
    public int numIslands(char[][] grid) {
        m = grid.length;
        n = grid[0].length;
        vis = new boolean[m][n];
        
        int islands = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (!valid(i, j, grid)) {
                    continue;
                }
                ++islands;
                dfs(i, j, grid);
            }
        }
        return islands;
    }
    private void dfs(int i, int j, char[][] grid) {
        if (!valid(i, j, grid)) {
            return;
        }
        
        vis[i][j] = true;
        for (int[] dir : dirs) {
            int R = dir[0] + i;
            int C = dir[1] + j;

            dfs(R, C, grid);
        }
    }
    private boolean valid(int i, int j, char[][] grid) {
        return !(i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == '0' || vis[i][j]);
    }
}