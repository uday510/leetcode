class Solution {
    public List<Integer> eventualSafeNodes(int[][] edges) {
        
        int n = edges.length;
        int[] state = new int[n];
        Arrays.fill(state, -1);

        List<Integer> res = new ArrayList<>();
        for (int idx = 0; idx < n; idx++) {
            if (dfs(idx, edges, state)) {
                res.add(idx);
            }
        }

        return res;
    }

    private boolean dfs(int u, int[][] edges, int[] state) {
        if (state[u] != -1) return state[u] == 2;

        state[u] = 1;
        for (int v : edges[u]) {
            if (!dfs(v, edges, state)) {
                return false;
            }
        }

        state[u] = 2;
        return true;
    }
}