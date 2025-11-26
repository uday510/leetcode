class Solution {
    public int findCheapestPrice(int n, int[][] edges, int src, int dst, int k) {
        List<int[]>[] adjList = new ArrayList[n];

        for (int i = 0; i < n; i++) adjList[i] = new ArrayList<>();

        for (int[] e : edges) {
            int u = e[0], v = e[1], w = e[2];

            adjList[u].add(new int[] {v, w});
        }

        int[] dist = new int[n];
        int inf = Integer.MAX_VALUE;
        Arrays.fill(dist, inf);

        Queue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(x -> x[2]));
        dist[src] = 0;
        pq.offer(new int[] {src, 0, 0});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int u = cur[0], w = cur[1], stops = cur[2];

            if (stops > k) continue;

            for (int[] nxt : adjList[u]) {
                int v = nxt[0], w1 = nxt[1];

                if (w + w1 < dist[v]) {
                    dist[v] = w + w1;
                    pq.offer(new int[] {v, w + w1, stops + 1});
                }
            }
        }

        return dist[dst] == inf ? -1 : dist[dst];
    }
}