class Solution {

    int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};
    int numRows;
    int numCols;

    public int numIslands(char[][] grid) {
        numRows = grid.length;
        numCols = grid[0].length;
        int numIslands = 0;


        for (int row = 0; row < numRows; ++row) {
            for (int col = 0; col < numCols; ++col) {

                if (grid[row][col] == '#' || grid[row][col] == '0') continue;

                dfs(row, col, grid);
                numIslands++;
            }
        }

        return numIslands;
    }

    private void dfs(int row, int col, char[][] grid) {

        if (row < 0 || row >= numRows || col < 0 || col >= numCols 
            || grid[row][col] == '#' || grid[row][col] == '0') return;

        grid[row][col] = '#';
        
        for (int[] dir : dirs) {
            int R = dir[0] + row;
            int C = dir[1] + col;
            dfs(R, C, grid);
        }
    }
}