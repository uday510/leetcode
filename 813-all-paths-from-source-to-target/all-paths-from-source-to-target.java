class Solution {

    int n;
    List<Integer>[] adjList;
    Set<Integer> vis;
    List<List<Integer>> paths;

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        intialize(graph);
        dfs(0, new ArrayList<>());
        return paths;
    }
    private void dfs(Integer node, List<Integer> path) {
        path.add(node);
        if (node == n - 1) {
            paths.add(new ArrayList<>(path));
            return;
        }

        for (Integer v : adjList[node]) {
            dfs(v, path);
            path.removeLast();
        }
    }
    
    private void intialize(int[][] graph) {
        this.n = graph.length;
        adjList = new ArrayList[n];
        vis = new HashSet<>();
        paths = new ArrayList<>();

        for (int i = 0; i < n; ++i) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; ++i) {
            for (int v : graph[i]) {
                adjList[i].add(v);
            }
        }

    }
}