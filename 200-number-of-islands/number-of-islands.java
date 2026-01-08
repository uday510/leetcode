class Solution {

    private final static int[][] dirs = { {0, 1}, {1, 0}, {-1, 0}, {0, -1} };
    private final static char W = '0';
    private final static char L = '1';

    private boolean[][] vis;
    private int n, m;
    char[][] grid;

    public int numIslands(char[][] grid) {
        n = grid.length;
        m = grid[0].length;
        vis = new boolean[n][m];
        int islands = 0;
        this.grid = grid;


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (vis[i][j] || grid[i][j] == W) continue;

                islands++;
                bfs(i, j);
            }
        }

        return islands;
    }

    private void bfs(int i, int j) {

        Queue<int[]> queue = new ArrayDeque<>();

        vis[i][j] = true;
        queue.offer(new int[] {i, j});

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            for (int[] dir : dirs) {
                int nx = dir[0] + cur[0], ny = dir[1] + cur[1];

                if (nx < 0 || nx >= n || ny < 0
                 || ny >= m || vis[nx][ny] || grid[nx][ny] == W) continue;

                vis[nx][ny] = true;
                queue.offer(new int[] {nx, ny});
            }
        }
    }   
}