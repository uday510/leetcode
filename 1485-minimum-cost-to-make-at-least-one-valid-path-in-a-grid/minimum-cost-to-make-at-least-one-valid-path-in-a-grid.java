class Solution {
    public int minCost(int[][] arr) {
        
        int n = arr.length, m = arr[0].length;
        int unk = Integer.MAX_VALUE;
        int[][] dists = new int[n][m];

        for (int[] r : dists) {
            Arrays.fill(r, unk);
        }

        int[][] DIRs = { {}, {0, 1}, {0, -1}, {1, 0}, {-1, 0} };
        Deque<int[]> queue = new ArrayDeque<>();

        dists[0][0] = 0;
        queue.offer(new int[] {0, 0, 0});

        while (!queue.isEmpty()) {
            int[] cur = queue.pollFirst();
            int x = cur[0], y = cur[1], w = cur[2];

            if (x == n - 1 && y == m - 1) {
                return w;
            }

            for (int idx = 1; idx < DIRs.length; idx++) {
                int[] nxt = DIRs[idx];
                int nx = nxt[0] + x, ny = nxt[1] + y;

                if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                    continue;
                }

                int w1 = w + (idx == arr[x][y] ? 0 : 1);

                if (w1 >= dists[nx][ny]) {
                    continue;
                }

                dists[nx][ny] = w1;
                if (idx == arr[x][y]) {
                    queue.offerFirst(new int[] {nx, ny, w1});
                } else {
                    queue.offerLast(new int[] {nx, ny, w1});
                }

            }
        }

        return -1;
    }
}