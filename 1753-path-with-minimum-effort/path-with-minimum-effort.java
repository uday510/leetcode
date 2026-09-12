class Solution {
    
    public int minimumEffortPath(int[][] h) {
        int n = h.length, m = h[0].length;
        int[][] dists = new int[n][m];
        Queue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[2] - o2[2]);

        int[][] dirs = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

        int unk = Integer.MAX_VALUE;
        for (int[] r : dists) {
            Arrays.fill(r, unk);
        }

        dists[0][0] = 0;
        pq.offer(new int[] {0, 0, 0});
        
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int x1 = cur[0], y1 = cur[1], w = cur[2];

            if (dists[x1][y1] < w) {
                continue;
            }

            for (int[] nxt : dirs) {
                int x2 = nxt[0] + x1, y2 = nxt[1] + y1;

                if (x2 < 0 || x2 >= n || y2 < 0 || y2 >= m) {
                    continue;
                }

                int w1 = Math.max(w, Math.abs(h[x1][y1] - h[x2][y2]));

                if (w1 < dists[x2][y2]) {
                    dists[x2][y2] = w1;
                    pq.offer(new int[] {x2, y2, w1});
                }
            }
        }

        return dists[n - 1][m - 1];
    }

}