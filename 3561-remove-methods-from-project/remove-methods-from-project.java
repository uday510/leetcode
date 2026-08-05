class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] edges) {
        List<Integer>[] adj = new ArrayList[n];

        for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();

        for (int[] e : edges) {
            int u = e[0], v = e[1];
            adj[u].add(v);
        }

        List<Integer> res = new ArrayList<>();
        boolean[] vis = new boolean[n];

        Deque<Integer> st = new ArrayDeque<>();
        vis[k] = true;
        st.push(k); 
        while (!st.isEmpty()) {
            int u = st.pop();
            for (int v : adj[u]) {
                if (vis[v]) continue;
                vis[v] = true;
                st.push(v);
            }
        }

        for (int[] e : edges) {
            if (!vis[e[0]] && vis[e[1]]) {
                return IntStream.range(0, n).boxed().toList();
            }
        }

        for (int i = 0; i < n; i++) {
            if (!vis[i]) res.add(i);
        }

        return res;
    }

}