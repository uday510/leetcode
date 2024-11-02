class Solution {
    public void rotate(int[][] matrix) {
        transpose(matrix);
        for (int[] mt : matrix)
             System.out.println(Arrays.toString(mt));
        reverseRows(matrix);
    }
    void transpose(int[][] matrix) {
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = i; j < matrix[i].length; ++j) {
                int tmp = matrix[j][i];
                matrix[j][i] = matrix[i][j];
                matrix[i][j] = tmp;
            }
        }
    }
    void reverseRows(int[][] matrix) {
       for (int i = 0; i < matrix.length; ++i) {
            int st = 0;
            int en = matrix[i].length - 1;
            while (st < en) {
                int tmp = matrix[i][st];
                matrix[i][st] = matrix[i][en];
                matrix[i][en] = tmp;
                ++st;
                --en;
            }
       }
       
    }
}