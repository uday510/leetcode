class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;

        List<int[]>[] adjList = new ArrayList[n];

        for (int i = 0; i < n; i++) adjList[i] = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int[] p1 = points[i];
            for (int j = i + 1; j < n; j++) {
                int[] p2 = points[j];
                int x1 = p1[0], y1 = p1[1], x2 = p2[0], y2 = p2[1];

                int manhattanDistance = getManhattanDistance(x1, y1, x2, y2);

                adjList[i].add(new int[] {j, manhattanDistance});
                adjList[j].add(new int[] {i, manhattanDistance});
            }
        }

        boolean[] inMST = new boolean[n];
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(edge -> edge[1]));
        pq.offer(new int[] {0, 0});
        int totalWeight = 0, vis = 0;


        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int u = cur[0], w = cur[1];

            if (inMST[u]) continue;

            inMST[u] = true;
            vis++;
            totalWeight += w;

            for (int[] nxt : adjList[u]) {
                int v = nxt[0], w1 = nxt[1];

                if (!inMST[v]) {
                    pq.offer(new int[] {v, w1});
                }
            }
        }

        return vis == n ? totalWeight : -1;

    }

    private int getManhattanDistance(int x1, int y1, int x2, int y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }
}
