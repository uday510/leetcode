class Solution {
    boolean[][] seen;
    int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        seen = new boolean[m][n];
    
        int islands = 0;
        
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                int currVal = grid[i][j];
                if (currVal == '0' || seen[i][j]) {
                    continue;
                }
                ++islands;
                dfs(i,j, m, n, grid);
            }
        }
        return islands;
    }
    
    private void dfs(int i, int j, int m, int n, char[][] grid) {
        if (!valid(i,j,m,n,grid)) 
            return;
        
        seen[i][j] = true;
        for (int[] dir: directions) {
            int newI = dir[0] + i;
            int newJ = dir[1] + j;
        
            dfs(newI, newJ, m, n, grid);
        }
    }
    private boolean valid(int i, int j, int m, int n, char[][] grid) {
        return !(i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == '0' || seen[i][j]);
    }
}