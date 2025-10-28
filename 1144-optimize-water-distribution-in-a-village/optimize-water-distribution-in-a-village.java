class Solution {
    public int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
        List<int[]>[] adjList = new ArrayList[n + 1];

        for (int i = 0; i <= n; i++) adjList[i] = new ArrayList<>();

        for (int[] p : pipes) {
            int u = p[0], v = p[1], w = p[2];

            adjList[u].add(new int[] {v, w});
            adjList[v].add(new int[] {u, w});
        }

        for (int i = 0; i < n; i++) {
            int u = 0, v = i + 1, w = wells[i];

            adjList[u].add(new int[] {v, w});
            adjList[v].add(new int[] {u, w});
        }

        boolean[] inMST = new boolean[n + 1];

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(edge -> edge[1]));
        pq.offer(new int[] {0, 0});
        int totalWeight = 0;

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int u = cur[0], w = cur[1];

            if (inMST[u]) continue;

            inMST[u] = true;
            totalWeight += w;

            for (int[] nxt : adjList[u]) {
                int v = nxt[0], w1 = nxt[1];

                if (!inMST[v]) {
                    pq.offer(new int[] {v, w1});
                }
            }
        }

        return totalWeight;
    }
}