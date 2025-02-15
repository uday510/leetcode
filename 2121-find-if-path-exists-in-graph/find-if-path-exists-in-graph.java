import java.util.*;
class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        Graph graph = new Graph(edges, false);
        DFS dfs = new DFS(graph);
        return dfs.pathExists(source, destination);
    }
}

class DFS {
    private final Map<Integer, List<Integer>> graph;

    DFS(Graph g) {
        this.graph = g.getGraph();
    }

    public boolean pathExists(int startNode, int targetNode) {
        if (startNode == targetNode) return true;  // Edge case

        Set<Integer> visited = new HashSet<>();
        Stack<Integer> stack = new Stack<>();
        stack.push(startNode);

        while (!stack.isEmpty()) {
            int node = stack.pop();
            if (visited.contains(node)) continue;

            visited.add(node);
            if (node == targetNode) return true;

            for (int neighbor : graph.getOrDefault(node, Collections.emptyList())) {
                if (!visited.contains(neighbor)) {
                    stack.push(neighbor);
                }
            }
        }
        return false;
    }
}

class Graph {
    private final Map<Integer, List<Integer>> graph;

    public Graph(int[][] edges, boolean isDirected) {
        graph = new HashMap<>();
        buildGraph(edges, isDirected);
    }

    private void buildGraph(int[][] edges, boolean isDirected) {
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            graph.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
            if (!isDirected) {
                graph.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
            }
        }
    }

    public Map<Integer, List<Integer>> getGraph() {
        return graph;
    }
}