class Solution {
    public int swimInWater(int[][] arr) {
        
        int n = arr.length;
        int[][] dists = new int[n][n];
        int unk = Integer.MAX_VALUE;

        for (int[] r : dists) {
            Arrays.fill(r, unk);
        }

        Queue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(k -> k[2]));
        dists[0][0] = arr[0][0];
        pq.offer(new int[] {0, 0, arr[0][0]});

        int[][] dirs = { {0, 1}, {1, 0}, {-1, 0}, {0, -1} };

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int x1 = cur[0], y1 = cur[1], w = cur[2];

            if (dists[x1][y1] < w) {
                continue;
            }

            for (int[] dir : dirs) {
                int x2 = dir[0] + x1, y2 = dir[1] + y1;

                if (x2 < 0 || x2 >= n || y2 < 0 || y2 >= n) {
                    continue;
                }

                int w2 = Math.max(w, arr[x2][y2]);

                if (w2 < dists[x2][y2]) {
                    dists[x2][y2] = w2;
                    pq.offer(new int[] {x2, y2, w2});
                }
            }
        }

        return dists[n - 1][n - 1];
    }
}