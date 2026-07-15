class Solution {
    public int minReorder(int n, int[][] conns) {
        
        List<int[]>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++)
            adj[i] = new ArrayList<>();
        
        for (int[] con : conns) {
            int u = con[0], v = con[1];
            adj[u].add(new int[] {v, 1});
            adj[v].add(new int[] {u, 0});
        }


        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] vis = new boolean[n];

        vis[0] = true;
        queue.offer(0);

        int mn = 0;

        while (!queue.isEmpty()) {
            int u = queue.poll();

            for (int[] nxt : adj[u]) {
                int v = nxt[0], w = nxt[1];
                if (vis[v]) continue;

                vis[v] = true;
                mn += w;
                queue.offer(v);
            }
        }


        return mn;
    }
}