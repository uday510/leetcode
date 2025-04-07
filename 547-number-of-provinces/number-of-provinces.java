class Solution {
    int[][] edges;
    Set<Integer> vis;
    int n;
    public int findCircleNum(int[][] isConnected) {
        edges = isConnected;
        vis = new HashSet<>();
        n = edges.length;
        int numProvinces = 0;

        for (int i = 0; i < n; ++i) {
            if (!vis.contains(i)) {
                numProvinces++;
                dfs(i, edges[i]);
            }
        }

        return numProvinces;
    }
    private void dfs(int node, int[] nei) {
        
        for (int i = 0; i < n; ++i) {
            if (nei[i] == 1 && !vis.contains(i)) {
                vis.add(i);
                dfs(i, edges[i]);
            }
        }
    }
}