class Solution {
    public int numIslands(char[][] grid) {
         int count = 0;
        if (grid == null || grid.length == 0) {
            return count;
        }
        
        int row = grid.length;
        int col = grid[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++){
                if (grid[i][j] == '1') {
                    count++;
                    dfs(grid, i, j);
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int i, int j) {
        int row = grid.length;
        int col = grid[0].length;
        if (!isValid(grid, i, j) || grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '0';
        dfs(grid, i - 1, j);
        dfs(grid, i + 1, j);
        dfs(grid, i, j - 1);
        dfs(grid, i, j + 1);
    }
    private boolean isValid(char[][] grid, int i, int j) {
        int row = grid.length;
        int col = grid[0].length;
        return i >= 0 && j >= 0 && i < row && j < col;
    }
}