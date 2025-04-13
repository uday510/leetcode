class Solution {
    List<Integer>[] adjList;
    Set<Integer> seen;
    int n;
    public List<Integer> eventualSafeNodes(int[][] graph) {
        intialize(graph);
        List<Integer> list = new ArrayList<>();

        for (int node = 0; node < n; ++node) {
            if (dfs(node, new HashSet<Integer>())) {
                list.add(node);
            }
        }

        Collections.sort(list);
        return list;
    }

    private boolean dfs(int node, Set<Integer> vis) {
        if (seen.contains(node)) return true;
        if (!vis.add(node)) return false;

        for (int neighbor : adjList[node]) {
            if (!dfs(neighbor, vis)) {
                return false;
            }
        }

        seen.add(node);
        return true;
    }

    private void intialize(int[][] graph) {
        n = graph.length;
        adjList = new ArrayList[n];
        seen = new HashSet<>();

        for (int i = 0; i < n; ++i) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < graph[i].length; ++j) {
                adjList[i].add(graph[i][j]);
            }
       }
    }
}