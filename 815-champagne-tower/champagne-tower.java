class Solution {
    public double champagneTower(int poured, int row, int col) {
        double[][] mat = new double[row + 2][col + 2];
        mat[0][0] = poured;

        for (int i = 0; i <= row; ++i) {
            for (int j = 0; j <= col; ++j) {
                   double overflow = Math.max(0, mat[i][j] - 1);
                   double val = overflow / 2.0;
                   mat[i+1][j] += val;
                   mat[i+1][j+1] += val;
            } 
        }
        
        return Math.min(1.0, mat[row][col]);
    }
}