class Solution {
    Integer[][] dp;
    int M;
    int N;
    int INF = (int) 1e9;
    public int minPathSum(int[][] grid) {
        M = grid.length;
        N = grid[0].length;
        
        dp = new Integer[M][N];
        
        return dfs(0, 0, grid);
    }
    public int dfs(int rowIdx, int colIdx, int[][] grid) {
         if (rowIdx >= M || colIdx >= N)
            return INF/2;
        
        if (rowIdx == M-1 && colIdx == N-1)
            return grid[rowIdx][colIdx];
        
        if (dp[rowIdx][colIdx] != null)
            return dp[rowIdx][colIdx];
        
        int curr = grid[rowIdx][colIdx];
        int right = dfs(rowIdx, colIdx+1, grid);
        int down = dfs(rowIdx+1, colIdx, grid);
        
        return dp[rowIdx][colIdx] = curr + Math.min(down, right);
    }
}