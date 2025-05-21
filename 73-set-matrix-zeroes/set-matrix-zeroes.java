class Solution {
    public void setZeroes(int[][] matrix) {
        int M = matrix.length, N = matrix[0].length;
        int[] rows = new int[M];
        int[] cols = new int[N];
        Arrays.fill(rows, -1);
        Arrays.fill(cols, -1);

        for (int i = 0; i < M; ++i) {
            for (int j = 0; j < N; ++j) {
                if (matrix[i][j] == 0) {
                   rows[i] = 0;
                   cols[j] = 0;
                }
            }
        }

        for (int i = 0; i < M; ++i) {
            for (int j = 0; j < N; ++j) {
                if (rows[i] == 0 || cols[j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

    }
}