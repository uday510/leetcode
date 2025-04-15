class Solution {

    private List<Integer>[] adjList;
    private int destination;
    private List<List<Integer>> paths;

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        adjList = new ArrayList[graph.length];
        destination = graph.length - 1;
        paths = new ArrayList<>();

        for (int i = 0; i < graph.length; ++i) adjList[i] = new ArrayList<>();

        for (int i = 0; i < graph.length; ++i) {
            for (int v : graph[i]) {
                adjList[i].add(v);
            }
        }

        dfs(0, new ArrayList<>(Arrays.asList(0)));

        return paths;
    }
    private void dfs(int node, List<Integer> path) {
        if (node == destination) {
            paths.add(new ArrayList<>(path));
            return;
        }

        for (int nei : adjList[node]) {
            path.add(nei);
            dfs(nei, path);
            path.removeLast();
        }
    }
}