class Solution {
    public int minCost(int n, int[][] edges) {
        
        List<int[]>[] adj = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int[] e : edges) {
            int u = e[0], v = e[1], w = e[2];
            adj[u].add(new int[] {v, w});
            adj[v].add(new int[] {u, w * 2});
        }

        Queue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(k -> k[1]));

        int[] dist = new int[n];
        Arrays.fill(dist, (int) 1e9);

        pq.offer(new int[] {0, 0});
        dist[0] = 0;

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int u = cur[0], w = cur[1];

            if (u == n - 1) return w;

            for (int[] nxt : adj[u]) {
                int v = nxt[0], w1 = nxt[1];

                if (w + w1 < dist[v]) {
                    dist[v] = w + w1;
                    pq.offer(new int[] {v, w + w1});
                }
            }
        }

        return -1;

    }

}