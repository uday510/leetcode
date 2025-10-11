class Solution {

    int[][] edges;
    int[] dp;

    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        edges = graph;
        dp = new int[n];

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (dfs(i)) {
                list.add(i);
            }
        }

        return list;   
    }

    private boolean dfs(int u) {
        if (dp[u] != 0) {
            return dp[u] == 2;
        }

        dp[u] = 1;
        for (int v : edges[u]) {
            if (!dfs(v)) {
                return false;
            }
        }   

        dp[u] = 2;
        return true;
    }
}