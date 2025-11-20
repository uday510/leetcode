class Solution {

    private final static int[][] dirs = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    private final static int ROTTEN = 2;
    private final static int FRESH = 1;
    
    public int orangesRotting(int[][] grid) {
        int n = grid.length, m = grid[0].length;

        boolean[][] vis = new boolean[n][m];
        Queue<int[]> queue = new ArrayDeque<>();
        int fresh = 0, time = -1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == FRESH) {
                    fresh++;
                } else if (grid[i][j] == ROTTEN) {
                    vis[i][j] = true;
                    queue.offer(new int[] {i, j});
                } 
            }
        }

        if (fresh == 0) return 0;  

        while (!queue.isEmpty()) {
            int sz = queue.size();
            time++;
            for (int i = 0; i < sz; i++) {
                int[] cur = queue.poll();

                for (int[] dir : dirs) {
                    int nx = dir[0] + cur[0], ny = dir[1] + cur[1];

                    if (nx < 0 || nx >= n || ny < 0 || ny >= m ||
                     vis[nx][ny] || grid[nx][ny] != FRESH) continue;

                     vis[nx][ny] = true;
                     --fresh;
                    queue.offer(new int[] {nx, ny});
                }
            }
        }

        return fresh == 0 ? time : -1;
    }
}