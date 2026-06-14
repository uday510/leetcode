class Solution {
    public int minReorder(int n, int[][] cons) {
        
        List<int[]>[] adj = new ArrayList[n];
        boolean[] vis = new boolean[n];
        int mn = 0;

        for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();

        for (int[] con : cons) {
            int u = con[0], v = con[1];
            adj[u].add(new int[] {v, 1});
            adj[v].add(new int[] {u, 0});
        }

        Queue<Integer> queue = new ArrayDeque<>();

        vis[0] = true;
        queue.offer(0);

        while (!queue.isEmpty()) {
            int u = queue.poll();

            for (int[] nxt : adj[u]) {
                int v = nxt[0], w = nxt[1];

                if (vis[v]) continue;

                vis[v] = true;
                queue.offer(v);
                mn += w;
            }
        }

        return mn;
    }
}