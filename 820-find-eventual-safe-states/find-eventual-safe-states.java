class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        int[] vis = new int[n];
        Arrays.fill(vis, -1);

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (dfs(i, graph, vis)) {
                res.add(i);
            }
        }
        
        return res;
    }

    private boolean dfs(int u, int[][] edges, int[] vis) {
        if (vis[u] != -1) return vis[u] == 2;


        vis[u] = 1;
        for (int v : edges[u]) {
            if (!dfs(v, edges, vis)) {
                return false;
            }
        }

        vis[u] = 2;
        return true;
    }
} 