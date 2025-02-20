class Solution {
    List<int[]>[] adjList;
    Set<Integer> visited;
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        adjList = new ArrayList[n];
        visited = new HashSet<>();
        for (int idx = 0; idx < n; ++idx) {
            adjList[idx] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            int src = edge[0];
            int dest = edge[1];
            adjList[src].add(new int[]{dest});
            adjList[dest].add(new int[]{src});
        }

        return dfs(source, destination);
    }

    private boolean dfs(int node, int destination) {
        if (!visited.add(node)) {
            return false;
        }

        if (node == destination) {
            return true;
        }

        for (int[] neighbor : adjList[node]) {
            if (dfs(neighbor[0], destination)) {
                return true;
            }
        }

        return false;
    }
}