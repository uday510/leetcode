class Solution {
    public List<Integer> eventualSafeNodes(int[][] adj) {
        int n = adj.length;
        int[] vis = new int[n];

        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (dfs(i, adj, vis)) {
                res.add(i);
            }
        }

        return res;
    }

    private boolean dfs(int u, int[][] adj, int[] vis) {
        if (vis[u] != 0) return vis[u] == 2;

        vis[u] = 1;
        for (int v : adj[u]) {
            if (!dfs(v, adj, vis)) {
                return false;
            }
        }

        vis[u] = 2;
        return true;
    }
}