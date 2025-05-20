class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<int[]>[] adjList = new ArrayList[n];
        for (int idx = 0; idx < n; ++idx) {
            adjList[idx] = new ArrayList<>();
        }

        for (int[] flight : flights) {
            int u = flight[0], v = flight[1], w = flight[2];
            adjList[u].add(new int[] {v, w});
        }

        int[] dist = new int[n];
        int INF = (int) 1e9;
        Arrays.fill(dist, INF);

        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {src, 0, 0});
        dist[src] = 0;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int node = curr[0], w = curr[1], steps = curr[2];

            if (steps > k) continue;
            
            for (int[] next : adjList[node]) {
                int nei = next[0], neiW = next[1];
                int newW = w + neiW;
                
                if (newW < dist[nei]) {
                    dist[nei] = newW;
                    queue.offer(new int[] {nei, newW, steps + 1});
                }
            } 
        }

        return dist[dst] == INF ? -1 : dist[dst];
    }
}