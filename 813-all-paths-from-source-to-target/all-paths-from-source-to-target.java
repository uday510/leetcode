class Solution {

    List<List<Integer>> res;
    List<Integer>[] adjList;
    int n;

    public List<List<Integer>> allPathsSourceTarget(int[][] edges) {
        res = new ArrayList<>();   
        n = edges.length;
        adjList = new ArrayList[n];


        for (int i = 0; i < n; i++) {
            adjList[i] = new ArrayList<>();
            for (int v : edges[i]) {
                adjList[i].add(v);
            }
        }

        dfs(0, new ArrayList<>(List.of(0)));
        
        return res;
    }

    private void dfs(int i, List<Integer> path) {
        if (i == n - 1) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int v : adjList[i]) {
            path.add(v);
            dfs(v, path);

            path.removeLast();
        }
    }
}