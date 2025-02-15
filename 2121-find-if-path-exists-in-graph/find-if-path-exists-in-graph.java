class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        Graph graph = new Graph(edges);
        DFS dfs = new DFS(graph);

        return dfs.pathExists(source, destination);
    }
}

class DFS {
    private final Map<Integer, List<int[]>> graph;

    DFS(Graph g) {
        this.graph = g.getGraph();
    }

    public boolean pathExists(int startNode, int targetNode) {
        Set<Integer> visited = new HashSet<>();
        Stack<Integer> stack = new Stack<>();

        stack.push(startNode);

        while (!stack.isEmpty()) {
            int node = stack.pop();

            if (visited.contains(node)) continue;

            visited.add(node);

            if (node == targetNode) return true;

            List<int[]> neighbors = graph.getOrDefault(node, Collections.emptyList());
            neighbors.sort((a, b) -> Integer.compare(b[0], a[0]));

            for (int[] neighbor : neighbors) {
                if (visited.contains(neighbor[0])) {
                    continue;
                }

                stack.push(neighbor[0]);
            }
        }

        return false;
    }
}
class Graph {
    private final Map<Integer, List<int[]>> graph;

    public Graph(int[][] edges) {
        graph = new HashMap<>();
        buildGraph(edges);
    }

    private void buildGraph(int[][] edges) {
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            addEdge(u, v);
        }
    }

    private void addEdge(int u, int v) {
        graph.computeIfAbsent(u, k -> new ArrayList<>()).add(new int[]{v});
        graph.computeIfAbsent(v, k -> new ArrayList<>()).add(new int[]{u});
    
    }

    public Map<Integer, List<int[]>> getGraph() {
        return graph;
    }
}