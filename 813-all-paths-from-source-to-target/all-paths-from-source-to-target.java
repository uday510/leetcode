class Solution {
    List<List<Integer>> paths;
    List<int[]>[] adjList;
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        paths = new ArrayList<>();

        if (graph == null || graph.length == 0) {
            return paths;
        }

        adjList = new ArrayList[graph.length];

        for (int idx = 0; idx < graph.length; ++idx) {
            adjList[idx] = new ArrayList<>();
            for (int node : graph[idx]) {
                adjList[idx].add(new int[]{node});
            }
        }

        dfs(0, graph.length - 1, new ArrayList<>());
        return paths;
    }
    private void dfs(int node, int dest, ArrayList<Integer> path) {
        path.add(node);
        if (node == dest) {
            paths.add(new ArrayList<>(path));
            return;
        }

        for (int[] neighbor : adjList[node]) {
            dfs(neighbor[0], dest, path);
            path.removeLast();
        }
    }
}