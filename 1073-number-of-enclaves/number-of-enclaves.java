class Solution {
    public int numEnclaves(int[][] grid) {
        
        int n = grid.length, m = grid[0].length;
        int total = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    total += bfs(i, j, n, m, grid);
                }
            }
        }

        return total;
    }

    private int bfs(int i, int j, int n, int m, int[][] grid) {
        Queue<int[]> queue = new ArrayDeque<>();

        grid[i][j] = 0;
        queue.offer(new int[] {i, j});

        boolean flag = false;
        int cnt = 0;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0], y = cur[1];

            cnt++;
            if (!flag && isBoundary(x, y, n, m)) 
                flag = true;
            
            for (int[] nxt : new int[][] {{0, 1}, {1, 0}, {-1, 0}, {0, -1}}) {
                int nx = nxt[0] + x, ny = nxt[1] + y;

                if (nx < 0 || nx >= n || ny < 0 || ny >= m || grid[nx][ny] == 0)
                    continue;
                
                grid[nx][ny] = 0;
                queue.offer(new int[] {nx, ny});
            }
        }

        return flag ? 0 : cnt;
    }

    private boolean isBoundary(int x, int y, int n, int m) {
        return (x == 0 || x == n - 1 || y == 0 || y == m - 1);
    }
}