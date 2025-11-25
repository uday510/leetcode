class Solution {

    public void setZeroes(int[][] A) {

        boolean col0 = false;
        int n = A.length, m = A[0].length;

        for (int i = 0; i < n; i++) {
            if (A[i][0] == 0) col0 = true;
            for (int j = 1; j < m; j++) {
                if (A[i][j] == 0) {
                    A[i][0] = A[0][j] = 0;
                }
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (A[i][0] == 0 || A[0][j] == 0) {
                    A[i][j] = 0;
                }
            }
        }

        if (A[0][0] == 0) {
            for (int j = 0; j < m; j++) {
                A[0][j] = 0;
            }
        }

        if (col0) {
            for (int i = 0; i < n; i++) {
                A[i][0] = 0;
            }
        }

    }

}