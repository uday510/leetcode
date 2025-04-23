class Solution {

    int[][] dirs = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    int numRows;
    int numCols;
    char[][] grid;

    public int numIslands(char[][] grid) {
        numRows = grid.length;
        numCols = grid[0].length;
        this.grid = grid;
        int islands = 0;

        for (int i = 0; i < numRows; ++i) {
            for (int j = 0; j < numCols; ++j) {
                if (grid[i][j] == '1') {
                    dfs(i, j);
                    islands++;
                }
            }
        }

        return islands;
    }

    private void dfs(int i, int j) {
        if (i < 0 || i >= numRows || j < 0 || j >= numCols || grid[i][j] != '1') return;


        grid[i][j] = '#';
        for (int[] dir : dirs) {
            dfs(dir[0] + i, dir[1] + j);
        }
    }
}