class Solution {

    private static final int[][] dirs = { {0, 1}, {1, 0}, {-1, 0}, {0, -1} };
    public int shortestBridge(int[][] grid) {
        int n = grid.length, m = grid[0].length;

        Queue<int[]> queue = new ArrayDeque<>();
        boolean[][] vis = new boolean[n][m];

        boolean isFound = false;
        for (int x = 0; x < n && !isFound; x++) {
            for (int y = 0; y < m && !isFound; y++) {

                if (grid[x][y] == 1) {
                    dfs(x, y, n, m, vis, grid, queue);
                    isFound = true;
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0], y = cur[1], w = cur[2];

            for (int[] nxt : dirs) {
                int nx = nxt[0] + x, ny = nxt[1] + y;

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
    
    private void dfs(int x, int y, int n, int m, 
    boolean[][] vis, int[][] grid, 
    Queue<int[]> queue) {

        vis[x][y] = true;
        queue.offer(new int[] {x, y, 0});

        for (int[] nxt : dirs) {
            int nx = nxt[0] + x, ny = nxt[1] + y;
            if (isOutOfBounds(nx, ny, n, m) || vis[nx][ny] || grid[nx][ny] == 0)
                continue;

            dfs(nx, ny, n, m, vis, grid, queue);
        }
    }

    private boolean isOutOfBounds(int x, int y, int n, int m) {
        return x < 0 || x >= n || y < 0 || y >= m;
    }
}

/**

0 1
1 0


0:1 

 */