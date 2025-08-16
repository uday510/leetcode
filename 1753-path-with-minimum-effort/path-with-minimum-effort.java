class Solution {
    public int minimumEffortPath(int[][] heights) {
        int m = heights.length, n = heights[0].length, INF = 0x7fffffff;
        final int[][] dirs = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}},
        dist = new int[m][n];
        
        for (int[] row : dist) Arrays.fill(row, INF);
        dist[0][0] = 0;

        var pq = new PriorityQueue<int[]>((o1, o2) -> o1[2] - o2[2]);

        pq.offer(new int[]{0, 0, 0});
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int x1 = curr[0], y1 = curr[1], d1 = curr[2];

            if (dist[x1][y1] < d1) continue;
            for (int[] dir : dirs) {
                int x2 = dir[0] + x1, y2 = dir[1] + y1;

                if (x2 < 0 || x2 >= m || y2 < 0 || y2 >= n) continue;

                int diff = Math.abs(heights[x1][y1] - heights[x2][y2]);
                int d2 = Math.max(d1, diff);

                if (d2 < dist[x2][y2]) {
                    dist[x2][y2] = d2;
                    pq.offer(new int[]{x2, y2, d2});
                }
            }
        }

        return dist[m - 1][n - 1];
    }
}