class Solution {
    public void setZeroes(int[][] matrix) {
        int M = matrix.length, N = matrix[0].length;
        Set<String> set = new HashSet<>();

        for (int i = 0; i < M; ++i) {
            for (int j = 0; j < N; ++j) {
                String R = "ROW" + i;
                String C = "COL" + j;

                if (matrix[i][j] == 0) {
                    set.add(R);
                    set.add(C);
                }
            }
        }

        for (int i = 0; i < M; ++i) {
            for (int j = 0; j < N; ++j) {
                String R = "ROW" + i;
                String C = "COL" + j;

                if (set.contains(R) || set.contains(C)) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}