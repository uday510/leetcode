class Solution {
    public int maximalNetworkRank(int n, int[][] edges) {
        
        Set<Integer>[] adj = new HashSet[n];

        for (int i = 0; i < n; i++) adj[i] = new HashSet<>();

        for (int[] e : edges) {
            adj[e[1]].add(e[0]);
            adj[e[0]].add(e[1]);
        }

        int mx = 0;

        for (int u = 0; u < n; u++) {
            for (int v = u + 1; v < n; v++) {
                int cur = adj[u].size() + adj[v].size();

                if (adj[u].contains(v)) {
                    cur--;
                }

                mx = Math.max(mx, cur);
            }
        }

        return mx;
    }
}