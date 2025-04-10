class Solution {

    int n;
    List<Integer>[] adjList;
    Set<Integer> vis;
    int dest;

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        initialize(n, edges, destination);

        return dfs(source);
    }
    private boolean dfs(int node) {
        if (node == dest) return true;
        if (!vis.add(node)) return false;

        for (Integer vertex : adjList[node]) {
            if (dfs(vertex)) return true;
        }

        return false;
     }

    private void initialize(int n, int[][] edges, int destination) {
        this.n = n;
        adjList = new ArrayList[n];
        vis = new HashSet<>();
        dest = destination;

        for (int i = 0; i < n; ++i) adjList[i] = new ArrayList<>();

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            adjList[u].add(v);
            adjList[v].add(u);
        }
    }
}