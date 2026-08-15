class Solution {

    private static int[][] DIRs = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

    public int[][] updateMatrix(int[][] arr) {

        Queue<int[]> queue = new ArrayDeque<>();
        int n = arr.length, m = arr[0].length;
        int[][] res = new int[n][m];

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

            for (int[] nxt : DIRs) {
                int nx = nxt[0] + cur[0];
                int ny = nxt[1] + cur[1];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m || res[nx][ny] >= 0)
                    continue;
                
                res[nx][ny] = cur[2] + 1;
                queue.offer(new int[] {nx, ny, cur[2] + 1});
            }
        }

        return res;
    }
}