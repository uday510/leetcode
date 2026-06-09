import java.util.*;

class Solution {

    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        List<int[]>[] adj = new ArrayList[n];

        for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int[] p1 = points[i];
            for (int j = i + 1; j < n; j++) {
                int[] p2 = points[j];
                int x1 = p1[0], y1 = p1[1], x2 = p2[0], y2 = p2[1];

                int d = dist(x1, y1, x2, y2);

                adj[i].add(new int[]{j, d});
                adj[j].add(new int[]{i, d});
            }
        }

        boolean[] inMST = new boolean[n];
        Queue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(k -> k[1]));
        pq.offer(new int[]{0, 0});
        int total = 0, vis = 0;

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int u = cur[0], w = cur[1];

            if (inMST[u]) continue;

            inMST[u] = true;
            vis++;
            total += w;

            for (int[] nxt : adj[u]) {
                int v = nxt[0], w1 = nxt[1];

                if (!inMST[v]) {
                    pq.offer(new int[]{v, w1});
                }
            }
        }

        return vis == n ? total : -1;
    }

    private int dist(int x1, int y1, int x2, int y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }

}