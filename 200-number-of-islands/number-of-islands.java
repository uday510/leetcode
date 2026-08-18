class Solution {
    public int numIslands(char[][] grid) {
        int n = grid.length, m = grid[0].length;
        int total = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1') {
                    total++;
                    bfs(i, j, n, m, grid);
                }
            }
        }

        return total;
    }

    private void bfs(int i, int j, int n, int m, char[][] grid) {
        Queue<int[]> queue = new ArrayDeque<>();

        grid[i][j] = '0';
        queue.offer(new int[] {i, j});

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0], y = cur[1];

            for (int[] dir : new int[][] {{0, 1}, {1, 0}, {-1, 0}, {0, -1}}) {
                int nx = dir[0] + x, ny = dir[1] + y;

                if (nx < 0 || nx >= n || ny < 0 || ny >= m || grid[nx][ny] == '0') 
                    continue;

                grid[nx][ny] = '0';
                queue.offer(new int[] {nx, ny});
            }
        }
    }
}