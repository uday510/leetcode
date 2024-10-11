class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        int startRow = 0;
        int endRow = matrix.length - 1;
        int startCol = 0;
        int endCol = matrix[0].length - 1;

        while (startRow <= endRow && startCol <= endCol) {

            // go right
            for (int currCol = startCol; currCol <= endCol; ++currCol) {
                list.add(matrix[startRow][currCol]);
            }

            // go down
            for (int currRow = startRow + 1; currRow <= endRow; ++currRow) {
                list.add(matrix[currRow][endCol]);
            }

            // go left
            if (startRow == endRow) {
                break;
            }
            for (int currCol = endCol - 1;  currCol >= startCol; --currCol) {
                list.add(matrix[endRow][currCol]);
            }

            // go up
            if (startCol == endCol) {
                break;
            }
            for (int currRow = endRow - 1; currRow > startRow; --currRow) {
                list.add(matrix[currRow][startCol]);
            }

            ++startRow; --endRow; ++startCol; --endCol;
        }
        return list;
    }
}