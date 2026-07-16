class Solution {

    private static int[][] DIRs = { {0, 1}, {1, 0}, {-1, 0}, {0, -1} };
    public int shortestBridge(int[][] grid) {

        int n = grid.length, m = grid[0].length;
        boolean[][] vis = new boolean[n][m];
        Queue<int[]> queue = new ArrayDeque<>();

        boolean found = false;
        for (int i = 0; i < n && !found; i++) {
            for (int j = 0; j < m && !found; j++) {
                if (grid[i][j] == 1) {
                    dfs(i, j, n, m, grid, vis, queue);
                    found = true;
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0], y = cur[1], w = cur[2];

            for (int[] dir : DIRs) {
                int nx = dir[0] + x, ny = dir[1] + y;

                if (isOutOfBounds(nx, ny, n, m) || vis[nx][ny])
                    continue;

                if (grid[nx][ny] == 1)
                    return w;

                vis[nx][ny] = true;
                queue.offer(new int[] {nx, ny, w + 1});
            }
        }

        return -1;
    }

    private void dfs(int x, int y, int n, int m, int[][] grid, boolean[][] vis, Queue<int[]> queue) {

        queue.offer(new int[] {x, y, 0});

        vis[x][y] = true;
        for (int[] dir : DIRs) {
            int nx = dir[0] + x, ny = dir[1] + y;

            if (isOutOfBounds(nx, ny, n, m) || vis[nx][ny] || grid[nx][ny] == 0)
                continue;

            dfs(nx, ny, n, m, grid, vis, queue);
        }
    }

    private boolean isOutOfBounds(int x, int y, int n, int m) {
        return x < 0 || x >= n || y < 0 || y >= m;
    }
}