class Solution {
    public int minScore(int n, int[][] edges) {
        
        List<int[]>[] adj = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++)
            adj[i] = new ArrayList<>();
        
        int l = (int) 1e9, r = 0;
        for (int[] e : edges) {
            int u = e[0], v = e[1], w = e[2];

            adj[u].add(new int[] {v, w});
            adj[v].add(new int[] {u, w});

            l = Math.min(l, w);
            r += w;
        }

        boolean[] vis = new boolean[n + 1];
        int[] res = { Integer.MAX_VALUE };

        dfs(1, adj, vis, res);

        return res[0];
    }

    private void dfs(int u, List<int[]>[] adj, boolean[] vis, int[] res) {

        vis[u] = true;
        for (int[] nxt : adj[u]) {
            res[0] = Math.min(res[0], nxt[1]);
            if (vis[nxt[0]]) continue;
            dfs(nxt[0], adj, vis, res);
        }

    }
}