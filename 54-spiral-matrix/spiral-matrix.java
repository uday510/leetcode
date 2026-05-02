class Solution {
    public List<Integer> spiralOrder(int[][] arr) {
        
        int numRows = arr.length;
        int numCols = arr[0].length;
        int stRow = 0, enRow = numRows - 1;
        int stCol = 0, enCol = numCols - 1;

        List<Integer> res = new ArrayList<>();

        while (stRow <= enRow && stCol <= enCol) {

            // 1. Right, row(stRow) is fixed
            for (int col = stCol; col <= enCol; col++) {
                res.add(arr[stRow][col]);
            }

            // 2. Down, col(enCol) is fixed
            for (int row = stRow + 1; row <= enRow; row++) {
                res.add(arr[row][enCol]);
            }

            // 3. Left, row(enRow) is fixed

            if (stRow != enRow) {
                for (int col = enCol - 1; col >= stCol; col--) {
                    res.add(arr[enRow][col]);
                }
            }
        
            // 4. Up, col(stCol) is fixed
            if (stCol != enCol) {
                for (int row = enRow - 1; row > stRow; row--) {
                    res.add(arr[row][stCol]);
                }
            }

            stRow++;
            enRow--;

            stCol++;
            enCol--;
        }

        return res;
    }
}