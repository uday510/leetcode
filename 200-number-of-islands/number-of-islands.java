class Solution {

    private static final char I = '1';
    private static final char W = '0';
    private static final int[][] DIRs = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

    public int numIslands(char[][] grid) {
        
        int cnt = 0;
        int n = grid.length;
        int m = grid[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == I) {
                    cnt++;
                    bfs(grid, i, j, n, m);
                }
            }
        }

        return cnt;
    }

    private void bfs(char[][] arr, int i, int j, int n, int m) {
        arr[i][j] = W;
        Queue<int[]> queue = new ArrayDeque<>();

        queue.offer(new int[] {i, j});
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0], y = cur[1];

            for (int[] nxt : DIRs) {
                int nx = x + nxt[0];
                int ny = y + nxt[1];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m || arr[nx][ny] != I) 
                        continue;

                arr[nx][ny] = W;
                queue.offer(new int[] {nx, ny});
            }
        }
    }
}