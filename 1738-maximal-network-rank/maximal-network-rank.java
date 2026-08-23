class Solution {
    public int maximalNetworkRank(int n, int[][] edges) {
        
        boolean[][] con = new boolean[n][n];
        int[] deg = new int[n];

        for (int[] e : edges) {
            int u = e[0], v = e[1];
            con[u][v] = con[v][u] = true;
            deg[u]++; deg[v]++;
        }

        int mx = 0;
        for (int u = 0; u < n; u++) {
            for (int v = u + 1; v < n; v++) {
                int cur = deg[u] + deg[v] - (con[u][v] ? 1 : 0);
                mx = Math.max(mx, cur);
            }
        }
        
        return mx;
    }
}