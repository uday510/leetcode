class Solution {
    public int[][] rangeAddQueries(int n, int[][] queries) {
        int[][] mat = new int[n][n];

        for (int[] q : queries) {
            updateMat(q, mat);
        }

        return mat;
    }

    private void updateMat(int[] q, int[][] mat) {
        for (int i = q[0]; i <= q[2]; i++) {
            for (int j = q[1]; j <= q[3]; j++) {
                mat[i][j]++;
            }
        }
    }
}