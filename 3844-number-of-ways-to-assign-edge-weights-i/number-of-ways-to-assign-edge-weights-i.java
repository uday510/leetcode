class Solution {
    public int assignEdgeWeights(int[][] edges) {
        int n = 0;
        for (int[] e : edges) {
            n = Math.max(n, Math.max(e[0], e[1]));
        }

        List<Integer>[] adj = new ArrayList[n + 1];

        for (int i = 0; i <= n; i++) adj[i] = new ArrayList<>();

        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];

            adj[u].add(v);
            adj[v].add(u);
        }

        boolean[] vis = new boolean[n + 1];
        Queue<int[]> queue = new ArrayDeque<>();

        vis[1] = true;
        queue.offer(new int[] {1, 0});

        int mx = 0;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int u = curr[0], d = curr[1];

            mx = Math.max(d, mx);

            for (int v : adj[u]) {
                if (vis[v]) continue;
                vis[v] = true;
                queue.offer(new int[] {v, d + 1});
            }
        }
        
        return pow(mx - 1, 2, (int) 1e9 + 7);
    }

    private int pow(int n, int base, int mod) {
        if (n < 0) return 0;
        if (n == 0) return 1;

        long h = pow(n >> 1, base, mod);
        long p = h * h % mod;

        if ((n & 1) == 1) p = p * base % mod;

        return (int) p;
    }
}
