class Solution {
    int n;
    List<Integer>[] adjList;
    List<List<Integer>> res;
    public List<List<Integer>> allPathsSourceTarget(int[][] edges) {
        n = edges.length;
        adjList = new ArrayList[n];

        for (int u = 0; u < n; u++) {
            adjList[u] = new ArrayList<>();
            for (int v : edges[u]) {
                adjList[u].add(v);
            }
        }

        res = new ArrayList<>();
        
        dfs(0, new ArrayList<>(List.of(0)));
        return res;
    }
    private void dfs(int u, List<Integer> path) {
        if (u == n - 1) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int v : adjList[u]) {
            path.add(v);
            dfs(v, path);
            path.removeLast();
        }
    }
}