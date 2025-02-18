class Solution {
    List<Integer>[] adjList;
    boolean[] visited;
    int numComponents;
    public int countComponents(int n, int[][] edges) {
        initialize(n, edges);

        for (int idx = 0; idx < n; ++idx) {
            if (!visited[idx]) {
                numComponents++;
                dfs(idx);
            }
        }

        return numComponents;
    }

    private void dfs(int node) {
        visited[node] = true;

        for (int neighbor : adjList[node]) {
            if (!visited[neighbor]) {
                dfs(neighbor);
            }
        }
    }

    private void initialize(int n, int[][] edges) {
        adjList = new ArrayList[n];
        visited = new boolean[n];
        numComponents = 0;

        for (int idx = 0; idx < n; ++idx) {
            adjList[idx] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            adjList[edge[0]].add(edge[1]);
            adjList[edge[1]].add(edge[0]);
        }
    }
}