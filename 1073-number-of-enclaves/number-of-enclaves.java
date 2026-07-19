class Solution {

    private static final int[][] DIRs = { {0, 1}, {1, 0}, {-1, 0}, {0, -1} };

    public int numEnclaves(int[][] grid) {

        int cnt = 0;
        boolean foundBoundary = false;
        int n = grid.length, m = grid[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    cnt += bfs(i, j, n, m, grid);
                }
            }
        }

        return cnt;
    }

    private int bfs(int i, int j, int n, int m, int[][] grid) {

        int cnt = 0;
        boolean foundBoundary = false;
        grid[i][j] = 0;
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {i, j});

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int dx = cur[0], dy = cur[1];

            cnt++;
            if (isBoundary(dx, dy, n, m)) {
               foundBoundary = true;
            }

            for (int[] nxt : DIRs) {
                int nx = dx + nxt[0], ny = dy + nxt[1];
                
                if (nx < 0 || nx >= n || ny < 0 || ny >= m || grid[nx][ny] != 1)
                    continue;
                
                grid[nx][ny] = 0;
                
                queue.offer(new int[] {nx, ny});
            }
        }
        
        return foundBoundary ? 0 : cnt;
    }

    private boolean isBoundary(int i, int j, int n, int m) {
        return (i == 0 || i == n - 1) || (j == 0 || j == m - 1);
    }
    
}