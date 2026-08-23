class Solution {

    private static final int[][] DIRs = { {0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    public List<List<Integer>> pacificAtlantic(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        Queue<int[]> aq = new ArrayDeque<>();
        Queue<int[]> pq = new ArrayDeque<>();
        boolean[][] visA = new boolean[n][m];
        boolean[][] visP = new boolean[n][m];

       for (int i = 0; i < n; i++) {
            visA[i][m - 1] = visP[i][0] = true;
            aq.offer(new int[] {i, m - 1});
            pq.offer(new int[] {i, 0});
       }

       for (int j = 0; j < m; j++) {
            visA[n - 1][j] = visP[0][j] = true;
            aq.offer(new int[] {n - 1, j});
            pq.offer(new int[] {0, j});
       }

       bfs(aq, grid, visA, n, m);
       bfs(pq, grid, visP, n, m);

       List<List<Integer>> res = new ArrayList<>();

       for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (visP[i][j] && visA[i][j]) {
                    res.add(List.of(i, j));
                }
            }
       }

       return res;
    }

    private void bfs(Queue<int[]> queue, int[][] grid, boolean[][] vis, int n, int m) {
        
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int dx = cur[0], dy = cur[1];
            for (int[] nxt : DIRs) {
                int nx = nxt[0] + dx;
                int ny = nxt[1] + dy;

                if (nx < 0 || nx >= n || ny < 0 || ny >= m || 
                    vis[nx][ny] || grid[dx][dy] > grid[nx][ny]) {
                    continue;
                }

                vis[nx][ny] = true;
                queue.offer(new int[] {nx, ny});
            }
        }
    }
}