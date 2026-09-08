class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        
        List<int[]>[] adj = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int[] t : times) {
            int u = t[0], v = t[1], w = t[2];
            adj[u].add(new int[] {v, w});
        }

        int[] dists = new int[n + 1];
        int unk = Integer.MAX_VALUE;
        
        Arrays.fill(dists, unk);

        Queue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(x -> x[1]));

        dists[k] = 0;
        pq.offer(new int[] {k, 0});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int u = cur[0], w = cur[1];
            if (dists[u] < w) 
                continue;
            
            for (int[] nxt : adj[u]) {
                int v = nxt[0], w1 = nxt[1];

                if (w + w1 < dists[v]) {
                    dists[v] = w + w1;
                    pq.offer(new int[] {v, w + w1});
                } 
            }
        }

        int mx = -1;
        for (int i = 1; i <= n; i++) {
            int d = dists[i];
            if (d == Integer.MAX_VALUE) {
                return -1;
            }

            mx = Math.max(mx, d);
        }

        return mx;
    }
}