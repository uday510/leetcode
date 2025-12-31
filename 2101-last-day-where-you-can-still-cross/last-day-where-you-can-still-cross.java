class Solution {

    private final int[][] DIRs = { {0, 1}, {1, 0}, {-1, 0}, {0, -1} };
    private int n, m;
    private int[][] cells;

    public int latestDayToCross(int rows, int cols, int[][] cells) {
        n = rows;
        m = cols;
        this.cells = cells;

        int l = 1, r = n * m + 1;

        while (l < r) {
            int m = (l + r) >> 1;

            if (bfs(m)) l = m + 1;
            else r = m;
        }

        return l - 1;
    }

    private boolean bfs(int d) {
        int[][] mat = new int[n][m];
        int cnt = 0;

        for (int i = 0; i < d; i++) {
            int[] cell = cells[i];
            mat[cell[0] - 1][cell[1] - 1] = 1;
        }

        Queue<int[]> queue = new ArrayDeque<>();

        for (int i = 0; i < m; i++) {
            if (mat[0][i] == 0) {
                queue.offer(new int[]{0, i});
                mat[0][i] = -1;
            }
        }

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int dx = cur[0], dy = cur[1];

            if (dx == n - 1) return true;

            for (int[] dir : DIRs) {
                int nx = dx + dir[0], ny = dy + dir[1];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m || mat[nx][ny] != 0) continue;

                mat[nx][ny] = -1;
                queue.offer(new int[]{nx, ny});
            }
        }

        return false;
    }
}