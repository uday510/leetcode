class Solution {

    private static final int[][] DIRs = { {0, 1}, {1, 0}, {-1, 0}, {0, -1} };

    public List<List<Integer>> pacificAtlantic(int[][] h) {
        
        int m = h.length;
        int n = h[0].length;
        List<List<Integer>> res = new ArrayList<>();

        Queue<int[]> pq = new ArrayDeque<>();
        Queue<int[]> aq = new ArrayDeque<>();

        boolean[][] pv = new boolean[m][n];
        boolean[][] av = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            pq.offer(new int[] {i, 0});
            aq.offer(new int[] {i, n - 1});
            pv[i][0] = av[i][n - 1] = true;
        }

        for (int j = 0; j < n; j++) {
            pq.offer(new int[] {0, j});
            aq.offer(new int[] {m - 1, j});
            pv[0][j] = av[m - 1][j] = true;
        }

        bfs(m, n, h, pq, pv);
        bfs(m, n, h, aq, av);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pv[i][j] && av[i][j]) {
                    res.add(List.of(i, j));
                }
            }
        }

        return res;

    }

    private void bfs(int m, int n, int[][] h, Queue<int[]> q, boolean[][] vis) {
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int dx = cur[0], dy = cur[1];

            for (int[] dir : DIRs) {
                int nx = dx + dir[0], ny = dy + dir[1];
                if (nx < 0 || nx >= m || ny < 0 || ny >= n || vis[nx][ny] || h[dx][dy] > h[nx][ny]) 
                    continue;

                vis[nx][ny] = true;
                q.offer(new int[] {nx, ny});


            }
        }
    }
}