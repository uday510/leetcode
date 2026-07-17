class Solution {

    private static int[][] DIRs = { {0, 1}, {1, 0}, {-1, 0}, {0, -1} };

    public int[][] updateMatrix(int[][] arr) {
        
        int n = arr.length, m = arr[0].length;
        int[][] res = new int[n][m];

        Queue<int[]> queue = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (arr[i][j] == 0) {
                    queue.offer(new int[] {i, j, 0});
                } else {
                    res[i][j] = -1;
                }
            }
        }

        if (queue.size() == n * m) return res;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0], y = cur[1], w = cur[2];

            for (int[] nxt : DIRs) {
                int nx = nxt[0] + x;
                int ny = nxt[1] + y;

                if (nx < 0 || nx >= n || ny < 0 || ny >= m || res[nx][ny] >= 0)
                    continue;

                res[nx][ny] = w + 1;
                queue.offer(new int[] {nx, ny, w + 1});
            }
        }

        return res;
    }
}