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
                bfs(idx);
            }
       }
    
    return numProvinces;
    }
    
    private void bfs(int node) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(node);
        visited[node] = true;

        while (!queue.isEmpty()) {
            node = queue.poll();

            for (int idx = 0; idx < n; ++idx) {
                if (graph[node][idx] == 1 && !visited[idx]) {
                    queue.offer(idx);
                    visited[idx] = true;
                }
            }
        }
    }
}