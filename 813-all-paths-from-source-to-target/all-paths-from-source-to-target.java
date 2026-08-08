class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] edges) {

        int n = edges.length;
        List<Integer>[] adj = new ArrayList[n];
        for (int idx = 0; idx < n; idx++) 
            adj[idx] = new ArrayList<>();
        
        for (int idx = 0; idx < n; idx++) {
            for (int v : edges[idx]) {
                adj[idx].add(v);
            }
        }

        List<List<Integer>> res = new ArrayList<>();
        dfs(0, n - 1, adj, new ArrayList<>(List.of(0)), res);

        return res;
    }

    private void dfs(int st, int en, List<Integer>[] adj, List<Integer> cur, List<List<Integer>> res) {

        if (st == en) {
            res.add(new ArrayList<>(cur));
            return;
        }

        for (int nxt : adj[st]) {
            cur.add(nxt);
            dfs(nxt, en, adj, cur, res);
            cur.removeLast();
        }
    }
}