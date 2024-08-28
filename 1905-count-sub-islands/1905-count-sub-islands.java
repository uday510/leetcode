class Solution {
    private int rows;
    private int cols;

    public int countSubIslands(int[][] grid1, int[][] grid2) {
        rows = grid1.length;
        cols = grid1[0].length;
        int subIslands = 0;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (grid2[row][col] == 1 && isSubIsland(grid1, grid2, row, col)) {
                    subIslands++;
                }
            }
        }
        return subIslands;
    }

    private boolean isSubIsland(int[][] grid1, int[][] grid2, int row, int col) {
        if (isOutOfBounds(row, col) || grid2[row][col] == 0) {
            return true;
        }

        grid2[row][col] = 0;
        boolean isSubIsland = grid1[row][col] != 0;

        isSubIsland &= isSubIsland(grid1, grid2, row + 1, col);
        isSubIsland &= isSubIsland(grid1, grid2, row - 1, col);
        isSubIsland &= isSubIsland(grid1, grid2, row, col + 1);
        isSubIsland &= isSubIsland(grid1, grid2, row, col - 1);

        return isSubIsland;
    }

    private boolean isOutOfBounds(int row, int col) {
        return row < 0 || row >= rows || col < 0 || col >= cols;
    }
}