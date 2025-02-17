class Solution {
    private Map<Integer, List<int[]>> graph;
    private Set<Integer> visited;
    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1) return false;

        initialize(edges);

        if (!dfs(0, -1)) return false;

        return visited.size() == n;
    } 

    private boolean dfs(int node, int parent) {
        if (!visited.add(node)) return false;

        List<int[]> edges = graph.getOrDefault(node, new ArrayList<>());
        for (int[] edge : edges) {
            if (edge[0] == parent) continue;

            if (!dfs(edge[0], node));
        }

        return true;
    }

    private void initialize(int[][] edges) {
        graph = new HashMap<>();
        visited = new HashSet<>();

        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            graph.computeIfAbsent(u, k -> new ArrayList<>()).add(new int[]{v});
            graph.computeIfAbsent(v, k -> new ArrayList<>()).add(new int[]{u});
        }
    }
}