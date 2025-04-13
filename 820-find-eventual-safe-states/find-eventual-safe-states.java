class Solution {
    List<Integer>[] adjList;
    int[] state;
    int n;
    public List<Integer> eventualSafeNodes(int[][] graph) {
        n = graph.length;
        adjList = new ArrayList[n];
        state = new int[n];
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; ++i) adjList[i] = new ArrayList<>();

        for (int i = 0; i < n; ++i) {
            for (int nei : graph[i]) {
                adjList[i].add(nei);
            }
        }

        for (int i = 0; i < n; ++i) {
            if (dfs(i)) list.add(i);
        }

        return list;
    }
    private boolean dfs(int node) {
        if (state[node] != 0) return state[node] == 2;

        state[node] = 1;
        for (int nei : adjList[node]) {
            if (!dfs(nei)) return false;
        }

        state[node] = 2;
        return true;
    }
}