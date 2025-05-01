class Solution {
    public int[][] updateMatrix(int[][] mat) {
        final int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        final int m = mat.length;
        final int n = mat[0].length;
        final int[][] res = new int[m][n];
        final Deque<int[]> queue = new ArrayDeque<>();

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (mat[i][j] == 0) {
                    queue.offerLast(new int[]{i, j, 0});
                    mat[i][j] = 2;
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] curr = queue.pollFirst();

            for (int[] dir : dirs) {
                int R = dir[0] + curr[0];
                int C = dir[1] + curr[1];
                int D = curr[2] + 1;

                if (R < 0 || R >= m || C < 0 || C >= n || mat[R][C] == 2) continue;

                res[R][C] = D;
                mat[R][C] = 2;

                queue.offerLast(new int[] {R, C, D});
            }
        }

        return res;
    }
}