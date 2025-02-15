class Solution {
    boolean[] visited;
    int[][] graph;
    int n;
    public int findCircleNum(int[][] isConnected) {
       this.n = isConnected.length;
       this.graph = isConnected;
       this.visited = new boolean[n];
       int numProvinces = 0;

       for (int idx = 0; idx < n; ++idx) {
            if (!visited[idx]) {
                numProvinces += 1;
                dfs(idx);
            }
       }
    
    return numProvinces;
    }

    private void dfs(int node) {
        visited[node] = true;
        for (int idx = 0; idx < n; ++idx) {
            if (graph[node][idx] == 1 && !visited[idx]) {
                dfs(idx);
            }
        }
    }
}