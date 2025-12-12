class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        
        List<int[]>[] adjList = new ArrayList[n];

        for (int i = 0; i < n; i++) adjList[i] = new ArrayList<>();

        for (int[] flight : flights) {
            int u = flight[0], v = flight[1], w = flight[2];

            adjList[u].add(new int[] {v, w});
        }

        int[][] dists = new int[k + 2][n];
        int unknown = (int) 1e9;

        for (int[] row : dists) Arrays.fill(row, unknown);

        Queue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt( x -> x[1]));

        dists[0][src] = 0;
        pq.offer(new int[] {src, 0, 0});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int u = cur[0], cost = cur[1], stops = cur[2];

            if (u == dst) return cost;

            if (stops == k + 1) continue;

            for (int[] nxt : adjList[u]) {
                int v = nxt[0], w = nxt[1];

                if (cost + w < dists[stops + 1][v]) {
                    dists[stops + 1][v] = cost + w;
                    pq.offer(new int[] {v, cost + w, stops + 1});
                }
            }
        }


        return -1;
    }
}