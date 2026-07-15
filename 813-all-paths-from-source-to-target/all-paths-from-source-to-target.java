class Solution {

    private List<List<Integer>> res;
    public List<List<Integer>> allPathsSourceTarget(int[][] edges) {
        
        res = new ArrayList<>();
        int n = edges.length;
        List<Integer>[] adj = new ArrayList[n];

        for (int u = 0; u < n; u++) {
            adj[u] = new ArrayList<>();
            for (int v : edges[u]) {
                adj[u].add(v);
            }
        }

        dfs(0, n, new ArrayList<>(List.of(0)), adj);
        return res;
    }

    private void dfs(int u, int n, List<Integer> cur, List<Integer>[] adj) {
        if (u == n - 1) {
            res.add(new ArrayList<>(cur));
            return;
        }

        for (int v : adj[u]) {
            cur.add(v);
            dfs(v, n, cur, adj);
            cur.removeLast();
        }

    }
}