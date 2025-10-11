class Solution {

    int[][] edges;
    int[] state;

    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        edges = graph;
        this.state = new int[n];

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (dfs(i)) {
                list.add(i);
            }
        }
        return list;
    }

    private boolean dfs(int u) {
        if (state[u] != 0) {
            return state[u] == 2;
        }

        state[u] = 1; // vis
        for (int v : edges[u]) {
            if (!dfs(v)) return false;
        }

        state[u] = 2;

        return true;
    }
}