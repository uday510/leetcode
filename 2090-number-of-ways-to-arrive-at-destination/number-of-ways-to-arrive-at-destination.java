class Solution {
    public int countPaths(int n, int[][] roads) {
        List<int[]>[] adjList = new ArrayList[n];
        long[] dist = new long[n];
        long[] ways = new long[n];

        for (int idx = 0; idx < n; ++idx) {
            adjList[idx] = new ArrayList<>();
        }

        for (int[] road : roads) {
            int u = road[0], v = road[1], w = road[2];

            adjList[u].add(new int[]{v, w});
            adjList[v].add(new int[]{u, w});
        }

        Arrays.fill(dist, Long.MAX_VALUE);
        var pq = new PriorityQueue<long[]>(Comparator.comparingLong(a -> a[1]));
        pq.offer(new long[]{0, 0});
        dist[0] = 0;
        ways[0] = 1;

        long MOD = (long) 1e9 + 7;

        while (!pq.isEmpty()) {
            long[] curr = pq.poll();
            int u = (int) curr[0];
            long d = curr[1];

            if (d > dist[u]) continue;

            for (int[] nei : adjList[u]) {
                int v = nei[0];
                long newDistance = nei[1] + d;

                if (newDistance > dist[v]) continue;

                if (newDistance < dist[v]) {
                    dist[v] = newDistance;
                    ways[v] = ways[u];
                    pq.offer(new long[]{v, newDistance});
                } 
                else if (newDistance == dist[v]) {
                    ways[v] += ways[u];
                }

                ways[v] %= MOD;
            }
        }

        return (int) ways[n - 1];
    }
}