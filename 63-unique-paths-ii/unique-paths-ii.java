class Solution {

    int numRows;
    int numCols;
    int[][] dp;

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        intialize(obstacleGrid);
        
        return dfs(0, 0, obstacleGrid);
    }

    private int dfs(int row, int col, int[][] grid) {
        if (row >= numRows || col >= numCols || grid[row][col] == 1) {
            return 0;
        }

        if (row == numRows - 1 && col == numCols - 1)
            return 1;

        if (dp[row][col] != -1) 
            return dp[row][col];

        return dp[row][col] = dfs(row + 1, col, grid) + dfs(row, col + 1, grid);
    }

    private void intialize(int[][] grid) {
        numRows = grid.length;
        numCols = grid[0].length;
        dp = new int[numRows][numCols];

        for (var row : dp) 
            Arrays.fill(row, -1);
    }
}