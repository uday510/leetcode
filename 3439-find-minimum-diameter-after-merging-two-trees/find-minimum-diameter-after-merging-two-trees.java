import java.util.*;

class Solution {
    List<List<Integer>> graph1;
    List<List<Integer>> graph2;

    public int minimumDiameterAfterMerge(int[][] edges1, int[][] edges2) {
        initialize(edges1, edges2);

        int d1 = findDiameter(graph1);
        int d2 = findDiameter(graph2);

        int c = (int) Math.ceil(d1 / 2.0) + (int) Math.ceil(d2 / 2.0) + 1;

        return Math.max(Math.max(d1, d2), c);
    }

    private void initialize(int[][] edges1, int[][] edges2) {
        graph1 = new ArrayList<>();
        graph2 = new ArrayList<>();

        buildGraph(edges1, graph1, edges1.length + 1);
        buildGraph(edges2, graph2, edges2.length + 1);
    }

    private int findDiameter(List<List<Integer>> graph) {
        Pair farthestNode = dfs(graph, 0, -1);
        Pair diameterInfo = dfs(graph, farthestNode.getNode(), -1);
        return diameterInfo.getDistance();
    }

    private Pair dfs(List<List<Integer>> graph, int node, int parent) {
        int maxDepth = 0;
        int farthestNode = node;

        for (int neighbor : graph.get(node)) {
            if (neighbor == parent) continue;

            Pair result = dfs(graph, neighbor, node);
            if (result.getDistance() + 1 > maxDepth) {
                maxDepth = result.getDistance() + 1;
                farthestNode = result.getNode();
            }
        }

        return new Pair(farthestNode, maxDepth);
    }

    private void buildGraph(int[][] edges, List<List<Integer>> graph, int n) {
        for (int i = 0; i < n; ++i) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
    }

    class Pair {
        private int node;
        private int distance;

        public Pair(int node, int distance) {
            this.node = node;
            this.distance = distance;
        }

        public int getNode() {
            return node;
        }

        public int getDistance() {
            return distance;
        }
    }
}