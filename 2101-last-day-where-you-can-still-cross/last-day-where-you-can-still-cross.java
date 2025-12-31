class Solution {

    private final int[][] DIRs = { {0, 1}, {1, 0}, {-1, 0}, {0, -1} };
    private int r, c;
    private int[][] cells;

    public int latestDayToCross(int r, int c, int[][] cells) {
        this.r = r;
        this.c = c;
        this.cells = cells;

        int left = 1, right = r * c + 1;

        while (left < right) {
            int m = (left + right) >> 1;

            if (bfs(m)) left = m + 1;
            else right = m;
        }

        return left - 1;
    }

    public boolean bfs(int d) {
        int[][] mat = new int[r][c];
        int cnt = 0;

        for (int i = 0; i < d; i++) {
            int[] cell = cells[i];
            mat[cell[0] - 1][cell[1] - 1] = 1;
        }

        Queue<int[]> queue = new ArrayDeque<>();

        for (int i = 0; i < c; i++) {
            if (mat[0][i] == 0) {
                queue.offer(new int[]{0, i});
                mat[0][i] = -1;
            }
        }

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int dx = cur[0], dy = cur[1];

            if (dx == r - 1) return true;

            for (int[] dir : DIRs) {
                int nx = dx + dir[0], ny = dy + dir[1];

                if (nx < 0 || nx >= r || ny < 0 || ny >= c || mat[nx][ny] != 0) continue;

                mat[nx][ny] = -1;
                queue.offer(new int[]{nx, ny});
            }
        }

        return false;
    }
}