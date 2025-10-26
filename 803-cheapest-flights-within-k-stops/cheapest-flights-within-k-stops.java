class Solution {
    public int findCheapestPrice(int n, int[][] edges, int src, int dst, int k) {
        List<int[]>[] adjList = new ArrayList[n];
        for (int i = 0; i < n; i++) adjList[i] = new ArrayList<>();

        for (int[] e : edges) {
            int u = e[0], v = e[1], w = e[2];
            adjList[u].add(new int[] {v, w});
        }

        int inf = Integer.MAX_VALUE;
        int[] dist = new int[n];
        Arrays.fill(dist, inf);

        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {src, 0, 0});
        dist[src] = 0;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int u = cur[0], curK = cur[1], w = cur[2];

            if (curK > k) continue;

            for (int[] nxt : adjList[u]) {
                int v = nxt[0], w1 = nxt[1];

                if (w + w1 < dist[v]) {
                    dist[v] = w + w1;
                    System.out.println(u + " -> " + v + " " + dist[v]);
                    queue.offer(new int[]{v, curK + 1, w + w1});
                }
            }
        }
    return dist[dst] == inf ? -1 : dist[dst];

    }
}