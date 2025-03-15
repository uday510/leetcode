class Solution {

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
        dfs(row + 1, col, grid);
        dfs(row - 1, col, grid);
        dfs(row, col + 1, grid);
        dfs(row, col - 1, grid);
    }
}