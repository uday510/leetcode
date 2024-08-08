class Solution {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        
        int startRow = 0;
        int startCol = 0;
        int endRow = n-1;
        int endCol = n-1;
        int val = 0;
        
        
        while (startRow <= endRow && startCol <= endCol) {
            
            for (int col = startCol; col <= endCol; ++col) {
                res[startRow][col] = ++val;
            }
            
            for (int row = startRow+1; row <= endRow; ++row) {
                res[row][endCol] = ++val;
            }
            
            if (startRow == endRow) break;
            for (int col = endCol-1; col > startCol; --col) {
                res[endRow][col] = ++val;
            }
            
            if (startCol == endCol) break;
            for (int row = endRow; row > startRow; --row) {
                res[row][startCol] = ++val;
            }
            
            ++startRow;
            --endRow;
            ++startCol;
            --endCol;
        }
        return res;
    }
}