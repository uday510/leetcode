class Solution {

    private int[][] edges;
    private int[] vis;
    private int n;
    public List<Integer> eventualSafeNodes(int[][] graph) {
        n = graph.length;
        edges = graph;
        vis = new int[n];

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (dfs(i)) {
                res.add(i);
            }
        }

        return res;
    }

    private boolean dfs(int u) {
        if (vis[u] != 0) return vis[u] == 2;

        vis[u] = 1;
        for (int v : edges[u]) {
            if (!dfs(v)) {
                return false;
            }
        }

        vis[u] = 2;
        return true;
    }
}