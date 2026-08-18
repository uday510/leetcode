class Solution {
    public int closedIsland(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int total = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (grid[i][j] == 0) {
                    total += bfs(i, j, n, m, grid);
                }
            }
        }

        return total;
    }

    private int bfs(int i, int j, int n, int m, int[][] grid) {
        Queue<int[]> queue = new ArrayDeque<>();

        grid[i][j] = 1;
        queue.offer(new int[] {i, j});

        boolean flag = false;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0], y = cur[1];

            for (int[] nxt : new int[][] { {0, 1}, {1, 0}, {-1, 0}, {0, -1}}) {
                int nx = nxt[0] + x, ny = nxt[1] + y;

                if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                    flag = true;
                    continue;
                }
                    
                if (grid[nx][ny] == 1) 
                    continue;
                
                grid[nx][ny] = 1;
                queue.offer(new int[] {nx, ny});
            }
        }

        return flag ? 0 : 1;
    }
}