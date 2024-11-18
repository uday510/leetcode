class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;

        int i = 0;
        int j = m - 1;

        while (i > -1 && i < n && j > -1 && j < m) {
            int curr = matrix[i][j];

            if (curr == target) {
                return true;
            } else if (curr < target) {
                i++;
            } else {
                j--;
            }
        } 
        return false;
    }
}