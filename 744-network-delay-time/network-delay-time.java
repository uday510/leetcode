class Solution {
    public int networkDelayTime(int[][] edges, int n, int src) {
        List<int[]>[] adj = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) adj[i] = new ArrayList<>();

        for (int[] e : edges) {
            int u = e[0], v = e[1], w = e[2];
            adj[u].add(new int[] {v, w});
        }

        Queue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(x -> x[1]));

        int unknown = Integer.MAX_VALUE;
        int[] dists = new int[n + 1];
        Arrays.fill(dists, unknown);
        
        dists[src] = 0;
        pq.offer(new int[] {src, 0});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int u = cur[0], w = cur[1];

            if (dists[u] < w) continue;

            for (int[] nxt : adj[u]) {
                int v = nxt[0], w1 = nxt[1];

                if (w + w1 < dists[v]) {
                    dists[v] = w + w1;
                    pq.offer(new int[] {v, w + w1});
                }
            }
        }

        int max = Integer.MIN_VALUE;;
        for (int i = 1; i <= n; i++) {
            if (dists[i] == unknown) {
                max = -1;
                break;
            }
            max = Math.max(max, dists[i]);
        }

        return max;
    }
}