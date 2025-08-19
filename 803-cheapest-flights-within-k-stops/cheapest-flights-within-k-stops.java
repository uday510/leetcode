class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<int[]>[] adjList = new ArrayList[n];
        for (int i = 0; i < n; ++i) adjList[i] = new ArrayList<>();

        for (int[] flight : flights) {
            int u = flight[0], v = flight[1], w = flight[2];
            adjList[u].add(new int[]{v, w});
        }
        
        int INF = 0x7fffffff;
        int[] dist = new int[n];
        Arrays.fill(dist, INF);

        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{src, 0, 0});
        dist[src] = 0;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int u1 = curr[0], w1 = curr[1], s1 = curr[2];

            if (s1 > k) continue;

            for (int[] next : adjList[u1]) {
                int v2 = next[0], w2 = w1 + next[1];

                if (w2 < dist[v2]) {
                    dist[v2] = w2;
                    queue.offer(new int[] {v2, w2, s1 + 1});
                }
            }
        }

        return dist[dst] == INF ? -1 : dist[dst];
    }
}