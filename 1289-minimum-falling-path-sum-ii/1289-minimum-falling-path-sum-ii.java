class Solution {
    Integer[][] dp;
    public int minFallingPathSum(int[][] grid) {
        dp = new Integer[grid.length][grid[0].length];

        int minFallingSum = Integer.MAX_VALUE;
        for (int i = 0; i < grid[0].length; ++i) {
            minFallingSum = Math.min(minFallingSum, dfs(grid, 0, i));
        }
        return minFallingSum;
    }
    
    public int dfs(int[][] grid, int row, int col) {
        if (col < 0 || col == grid.length) {
            return Integer.MAX_VALUE;
        }
        
        if (row == grid.length - 1) {
            return grid[row][col];
        }
        
        if (dp[row][col] != null) {
            return dp[row][col];
        }
        
        dp[row][col] = Integer.MAX_VALUE;
        for (int i = 0; i < grid[0].length; ++i) {
            if (i == col) {
                continue;
            }
            dp[row][col] = Math.min(dp[row][col], dfs(grid, row + 1, i) + grid[row][col]);
        }

        return dp[row][col];
    }
}