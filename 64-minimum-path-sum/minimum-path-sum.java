class Solution {

    int[][] dp;
    int rows;
    int cols;

    public int minPathSum(int[][] grid) {
        rows = grid.length;
        cols = grid[0].length;
        dp = new int[rows][cols];
        for (var row : dp)
            Arrays.fill(row, -1);

        return dfs(0, 0, grid);
    }
    private int dfs(int row, int col, int[][] grid) {
         if (row >= rows || col >= cols)
            return (int) 1e9;


        if (row == rows - 1 && col == cols - 1)
            return grid[row][col];

        if (dp[row][col] != -1) 
            return dp[row][col];

        int down = dfs(row + 1, col, grid);
        int right = dfs(row, col + 1, grid);

        return dp[row][col] = grid[row][col] + Math.min(down, right);
    }
}
