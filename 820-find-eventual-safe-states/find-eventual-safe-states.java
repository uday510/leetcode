class Solution {
    public List<Integer> eventualSafeNodes(int[][] adj) {
        int n = adj.length;
        int[] vis = new int[n + 1];
        Arrays.fill(vis, -1);

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (dfs(i, vis, adj)) {
                res.add(i);
            }
        }

        return res;
    }

    private boolean dfs(int u, int[] vis, int[][] adj) {
        if (vis[u] != -1) return vis[u] == 2;

        vis[u] = 1;
        for (int v : adj[u]) {
            if (!dfs(v, vis, adj)) {
                return false;
            }
        }

        vis[u] = 2;
        return true;
    }
}