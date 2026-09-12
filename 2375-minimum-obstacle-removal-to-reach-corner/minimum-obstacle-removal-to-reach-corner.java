class Solution {
    public int minimumObstacles(int[][] arr) {
        int n = arr.length, m = arr[0].length;
        int[][] dists = new int[n][m];
        int unk = Integer.MAX_VALUE;

        for (int[] r : dists) {
            Arrays.fill(r, unk);
        }

        int[][] dirs = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

        Queue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(k -> k[2]));

        dists[0][0] = arr[0][0];
        pq.offer(new int[] { 0, 0, arr[0][0] });

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int x1 = cur[0], y1 = cur[1], w = cur[2];

            if (dists[x1][y1] < w) {
                continue;
            }

            for (int[] dir : dirs) {
                int x2 = x1 + dir[0], y2 = y1 + dir[1];

                if (x2 < 0 || x2 >= n || y2 < 0 || y2 >= m) {
                    continue;
                }

                int w1 = w + arr[x2][y2];

                if (w1 < dists[x2][y2]) {
                    dists[x2][y2] = w1;
                    pq.offer(new int[] {x2, y2, w1});
                }
            }
        }

        return dists[n - 1][m - 1];
    }
}