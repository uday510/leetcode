import java.util.*;

class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        Graph graph = new Graph(edges, false); // Undirected graph
        return GraphSearch.bfs(graph, source, destination);
        // return GraphSearch.dfs(graph, source, destination); // Use DFS if needed
    }
}

class Graph {
    private final Map<Integer, List<Integer>> graph;

    public Graph(int[][] edges, boolean isDirected) {
        graph = new HashMap<>();
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

class GraphSearch {
    // \U0001f539 BFS: Best for Shortest Path & Unweighted Graphs
    public static boolean bfs(Graph g, int start, int target) {
        if (start == target) return true; 

        Map<Integer, List<Integer>> graph = g.getGraph();
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited.add(start);

        while (!queue.isEmpty()) {
            int node = queue.poll();
            if (node == target) return true;

            for (int neighbor : graph.getOrDefault(node, Collections.emptyList())) {
                if (visited.add(neighbor)) { // Avoids redundant contains() check
                    queue.offer(neighbor);
                }
            }
        }
        return false;
    }

    // \U0001f539 DFS: Best for Reachability & Backtracking Problems
    public static boolean dfs(Graph g, int start, int target) {
        if (start == target) return true; 

        Map<Integer, List<Integer>> graph = g.getGraph();
        Set<Integer> visited = new HashSet<>();
        Stack<Integer> stack = new Stack<>();
        stack.push(start);

        while (!stack.isEmpty()) {
            int node = stack.pop();
            if (node == target) return true;
            if (!visited.add(node)) continue;

            for (int neighbor : graph.getOrDefault(node, Collections.emptyList())) {
                if (!visited.contains(neighbor)) {
                    stack.push(neighbor);
                }
            }
        }
        return false;
    }
}