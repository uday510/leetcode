class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        
        int n = grid.length, m = grid[0].length;
        int mx = 0;

        for (int x = 0; x < n; x++) {
            for (int y = 0; y < m; y++) {

                if (grid[x][y] == 1) {
                    mx = Math.max(mx, bfs(x, y, n, m, grid));
                }
            }
        }

        return mx;
    }

    private int bfs(int x, int y, int n, int m, int[][] grid) {

        int cnt = 1;
        Queue<int[]> queue = new ArrayDeque<>();
        grid[x][y] = 0;
        queue.offer(new int[] {x, y});

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            
            for (int[] dir : new int[][] { {0, 1}, {1, 0}, {-1, 0}, {0, -1}}) {
                int nx = dir[0] + cur[0];
                int ny = dir[1] + cur[1];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m || grid[nx][ny] == 0)
                    continue;
                
                grid[nx][ny] = 0;
                cnt++;
                queue.offer(new int[] {nx, ny});
            }
        }

        return cnt;
    }
}