class Solution {
    public int diagonalSum(int[][] mat) {
        
        int sum = 0, n = mat.length, m = mat[0].length;

        for (int r = 0; r < n; r++) {
            sum += mat[r][r];
        }

        int r = 0;
        for (int c = m - 1; c > -1 && r < n; c--) {
            if (r != c) sum += mat[r][c];
            r++;
        }

        return sum;
    }
}