class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<int[]>[] adjList = new ArrayList[n];
        for (int i = 0; i < n; ++i) adjList[i] = new ArrayList<>();

        for (int[] flight : flights) {
            int u = flight[0], v = flight[1], w = flight[2];
            adjList[u].add(new int[] {v, w});
        }
        
        int INF = (int) 1e9;
        int[] dist = new int[n];
        Arrays.fill(dist, INF);

        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {src, 0, 0});
        dist[src] = 0;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int u = curr[0], weight = curr[1], stops = curr[2];

            if (stops > k) continue;

            for (int[] next : adjList[u]) {
                int v = next[0], w = next[1];
                int newW = w + weight;

                if (newW < dist[v]) {
                    dist[v] = newW;
                    queue.offer(new int[] {v, newW, stops + 1});
                }
            }
        }

        return dist[dst] == INF ? -1 : dist[dst];
    }
}