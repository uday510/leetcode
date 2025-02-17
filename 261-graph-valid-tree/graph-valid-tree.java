class Solution {
    private Map<Integer, List<Integer>> graph;
    private Set<Integer> visited;
    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1) return false;

        initialize(edges);

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, -1});
        visited.add(0);
        while (!queue.isEmpty()) {
            int[] arr = queue.poll();
            int node = arr[0];
            int parent = arr[1];
            List<Integer> neighbors = graph.getOrDefault(arr[0], new ArrayList<>());
            for (int neighbor : neighbors) {
                if (neighbor == parent) continue;
                if (!visited.add(neighbor)) return false;
                queue.offer(new int[]{neighbor, node});
            }
        }
        return visited.size() == n;
    } 

    private boolean dfs(int node, int parent) {
        if (!visited.add(node)) return false;

        List<Integer> edges = graph.getOrDefault(node, new ArrayList<>());
        for (int edge : edges) {
            if (edge == parent) continue;

            if (!dfs(edge, node));
        }

        return true;
    }

    private void initialize(int[][] edges) {
        graph = new HashMap<>();
        visited = new HashSet<>();

        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            graph.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
            graph.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
        }
    }
}