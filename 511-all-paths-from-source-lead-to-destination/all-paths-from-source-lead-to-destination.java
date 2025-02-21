class Solution {
    private List<Integer>[] adjList;
    enum Color { GRAY, BLACK };
    public boolean leadsToDestination(int n, int[][] edges, int source, int destination) {
        initialize(n, edges);
        return dfs(source, destination, new Color[n]);
    }
    private boolean dfs(int node, int dest, Color[] states) {
        if (states[node] != null) {
            return states[node] == Color.BLACK;
        }

        if (adjList[node].isEmpty()) {
            return node == dest;
        }

        states[node] = Color.GRAY;
        for (var neighbor : adjList[node]) {
            if (!dfs(neighbor, dest, states)) {
                return false;
            }
        }

        states[node] = Color.BLACK;
        return true;
    }

    private void initialize(int n, int[][] edges) {
        adjList = new ArrayList[n];

        for (int idx = 0; idx < n; ++idx) {
            adjList[idx] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            adjList[edge[0]].add(edge[1]);
        }
    }
}