class Solution {
    public int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
        List<int[]>[] adj = new ArrayList[n + 1];

        for (int i = 0; i <= n; i++) adj[i] = new ArrayList<>();

        for (int[] e : pipes) {
            int u = e[0], v = e[1], w = e[2];

            adj[u].add(new int[]{v, w});
            adj[v].add(new int[]{u, w});
        }

        for (int i = 0; i < n; i++) {
            adj[0].add(new int[]{i + 1, wells[i]});
            adj[i + 1].add(new int[]{0, wells[i]});
        }

        boolean[] vis = new boolean[n + 1];
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        int minCost = 0;

        pq.offer(new int[]{1, 0});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int v = cur[0], w = cur[1];

            if (vis[v]) continue;

            vis[v] = true;
            minCost += w;

            for (int[] next : adj[v]) {
                if (!vis[next[0]]) {
                    pq.offer(new int[] {next[0], next[1]});
                }
            }
        }

        return minCost;
    }
}

