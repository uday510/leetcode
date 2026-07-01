import java.util.*;

class Solution {

    public int maximumSafenessFactor(List<List<Integer>> grid) {


        int n = grid.size();
        int[][] dist1 = new int[n][n];
        Queue<int[]> queue = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            List<Integer> list = grid.get(i);

            for (int j = 0; j < n; j++) {
                int cur = list.get(j);

                if (cur == 1) {
                    dist1[i][j] = 0;
                    queue.offer(new int[] {i, j, 0});
                } else {
                    dist1[i][j] = -1;
                }
            }
        }

        int[][] DIRs = { {0, 1}, {1, 0}, {0, -1}, {-1, 0} };

        while (!queue.isEmpty()) {

            int sz = queue.size();

            for (int i = 0; i < sz; i++) {

                int[] cur = queue.poll();

                for (int[] dir : DIRs) {
                    int nx = dir[0] + cur[0], ny = dir[1] + cur[1], nw = cur[2] + 1;

                    if (nx > -1 && nx < n && ny > -1 && ny < n && dist1[nx][ny] == -1) {

                        dist1[nx][ny] = nw;
                        queue.offer(new int[] {nx, ny, nw});
                    }
                }
            }
        }


        Queue<int[]> pq = new PriorityQueue<>((a, b) -> b[2] - a[2]);
        int[][] dist2 = new int[n][n];

        for (int[] r : dist2) Arrays.fill(r, -1);
        dist2[0][0] = dist1[0][0];
        pq.offer(new int[] {0, 0, dist1[0][0]});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int r1 = cur[0], c1 = cur[1], w1 = cur[2];

            if (r1 == n - 1 && c1 == n - 1) return w1;

            for (int[] dist : DIRs) {
                int r2 = dist[0] + r1, c2 = dist[1] + c1;

                if (r2 < 0 || r2 >= n || c2 < 0 || c2 >= n || dist1[r2][c2] == -1) continue;
            
                int w2 = Math.min(w1, dist1[r2][c2]);

                if (w2 > dist2[r2][c2]) {
                    dist2[r2][c2] = w2;
                    pq.offer(new int[] {r2, c2, w2});
                }
            }
        }

        return -1;

    }


}