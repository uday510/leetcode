class Solution {
    int n;
    int m;
    public int[][] largestLocal(int[][] grid) {
       n = grid.length;
       m = grid[0].length;
        
        int[][] maxLocals = new int[n - 2][m - 2];
        
        for (int i = 0; i < n - 2; ++i) {
            for (int j = 0; j < m - 2; ++j) {
                 maxLocals[i][j] = getLocalMax(i, j, grid); 
            }
        }
        return maxLocals;
    }
    
    public int getLocalMax(int i, int j, int[][] grid) {
        int localMax = -1;
       
        for (int row = i; row < i + 3; ++row) {
            for (int col = j; col < j + 3; ++col) {
                localMax = Math.max(grid[row][col], localMax);
            }
        }
        
        return localMax;
    }
}