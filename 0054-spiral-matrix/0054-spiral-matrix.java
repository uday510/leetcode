class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int startRow = 0;
        int endRow = matrix.length - 1;
        int startCol = 0;
        int endCol = matrix[0].length - 1;
        List<Integer> res = new ArrayList<>();
        
        while (startRow <= endRow && startCol <= endCol) {

            for (int col = startCol; col <= endCol; ++col) {
                res.add(matrix[startRow][col]);
            }
            
            for (int row = startRow+1; row <= endRow; ++row) {
                res.add(matrix[row][endCol]);
            }
            
            if (startRow == endRow) break;
            for (int col = endCol-1; col >= startCol; --col) {
                res.add(matrix[endRow][col]);
            }
        
            if (startCol == endCol) break;
            for (int row = endRow-1; row > startRow; --row) {
                res.add(matrix[row][startCol]);
            }
            
            ++startRow;
            --endRow;
            ++startCol;
            --endCol;
        }
        
        return res;
    }
}