class Solution {
    private final int[][] directions = {
        {0,1},
        {1,0},
        {-1,0},
        {0,-1}
    };
    public int numIslands(char[][] grid) {
        int N = grid.length;
        int M = grid[0].length;
        int totalIslands = 0;
        boolean[][] vis = new boolean[N][M];

        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < M; ++j) {
                if (grid[i][j] == '1' && !vis[i][j]) {
                    totalIslands++;
                    dfs(i,j,grid,vis);
                }
            }
        }
        return totalIslands;
    }
    public void dfs(int i,int j, char[][] grid, boolean[][] vis) {
        if (i < 0 || i >= grid.length 
            || j < 0 || j >= grid[0].length ||
            grid[i][j] == '0' || vis[i][j]) {
                return;
        }

        vis[i][j] = true;
        for (int[] dir : directions) {
            int newRow = dir[0] + i;
            int newCol = dir[1] + j;
            dfs(newRow, newCol, grid, vis);
        }
    }
}