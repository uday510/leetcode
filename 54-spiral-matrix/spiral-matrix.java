class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> order = new ArrayList<>();
        int stRow = 0, enRow = matrix.length - 1, stCol = 0, enCol = matrix[0].length - 1;


        while (stRow <= enRow && stCol <= enCol) {

            for (int col = stCol; col <= enCol; ++col) {
                order.add(matrix[stRow][col]);
            }

            for (int row = stRow + 1; row <= enRow; ++row) {
                order.add(matrix[row][enCol]);
            }

            if (stRow == enRow) break;
            for (int col = enCol - 1; col >= stCol; --col) {
                order.add(matrix[enRow][col]);
            }

            if (stCol == enCol) break;
            for (int row = enRow - 1; row > stRow; --row) {
                order.add(matrix[row][stCol]);
            }

            ++stRow;
            ++stCol;
            --enRow;
            --enCol;
        }



        return order;
    }
}