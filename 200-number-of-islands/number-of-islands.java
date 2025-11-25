class Solution {

    private final static int[][] dirs =  { {0, 1}, {1, 0}, {0, -1}, {-1, 0} };
    private final static char WATER = '0';
    private final static char LAND = '1';

    boolean[][] vis;
    int n, m;
    char[][] grid;

    public int numIslands(char[][] grid) {
        n = grid.length;
        m = grid[0].length;
        vis = new boolean[n][m];
        int numIslands = 0;
        this.grid = grid;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (vis[i][j] || grid[i][j] == WATER) continue;

                numIslands++;
                bfs(i, j);
            }
        }

        return numIslands;
    }

    private void bfs(int i, int j) {
        Queue<int[]> queue = new ArrayDeque<>();

        vis[i][j] = true;
        queue.offer(new int[] {i, j});

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            for (int[] dir : dirs) {
                int nx = dir[0] + cur[0], ny = dir[1] + cur[1];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m || vis[nx][ny] || grid[nx][ny] == WATER) continue;

                vis[nx][ny] = true;
                queue.offer(new int[] {nx, ny});
            }
        }
    }
}