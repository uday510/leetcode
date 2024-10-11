class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int currNum = 0;
        int startRow = 0;
        int startCol = 0;
        int endRow = n-1;
        int endCol = n-1;

        while (startRow <= endRow && startCol <= endCol) {

            for (int currCol = startCol; currCol <= endCol; ++currCol) {
                matrix[startRow][currCol] = ++currNum;
            }
            for (int currRow = startRow + 1; currRow <= endRow; ++currRow) {
                matrix[currRow][endCol] = ++currNum;
            }

            if (startRow == endRow) {
                break;
            }

            for (int currCol = endCol - 1; currCol >= startCol; --currCol) {
                matrix[endRow][currCol] = ++currNum;
            }

            if (startCol == endCol) {
                break;
            }

            for (int currRow = endRow - 1; currRow > startRow; --currRow) {
                matrix[currRow][startCol] = ++currNum;
            }

            ++startRow;  --endRow;  ++startCol; --endCol;
        }
        return matrix;
    }
}