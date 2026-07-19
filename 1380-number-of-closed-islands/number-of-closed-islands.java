class Solution {

    private static final int[][] DIRs = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

    public int closedIsland(int[][] grid) {

        int n = grid.length, m = grid[0].length;
        int closedIslands = 0;

        for (int x = 0; x < n; x++) {
            for (int y = 0; y < m; y++) {

                if (grid[x][y] == 0) {
                    closedIslands += bfs(x, y, n, m, grid);
                }
            }
        }

        return closedIslands;
    }

    private int bfs(int x, int y, int n, int m, int[][] grid) {

        boolean isClosed = true;
        Queue<int[]> queue = new ArrayDeque<>();
        grid[x][y] = 0;
        queue.offer(new int[] {x, y});

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int dx = cur[0], dy = cur[1];

            for (int[] nxt : DIRs) {
                int nx = dx + nxt[0], ny = dy + nxt[1];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                    isClosed = false;
                    continue;
                }
                
                if (grid[nx][ny] == 0) {
                    grid[nx][ny] = 1;
                    queue.offer(new int[] {nx, ny});
                }
                    
            }
        }
        
        return isClosed ? 1 : 0;
    }
    
}