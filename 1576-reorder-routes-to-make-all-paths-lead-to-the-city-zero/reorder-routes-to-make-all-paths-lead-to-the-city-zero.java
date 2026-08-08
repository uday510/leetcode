class Solution {

    public int minReorder(int n, int[][] conns) {

        List<int[]>[] adj = new ArrayList[n];
        for (int idx = 0; idx < n; idx++)
            adj[idx] = new ArrayList<>();

        for (int[] con : conns) {
            int u = con[0], v = con[1];
            adj[u].add(new int[] {v, 1});
            adj[v].add(new int[] {u, 0});
        }

        boolean[] vis = new boolean[n];
        Queue<Integer> queue = new ArrayDeque<>();
        
        vis[0] = true;
        queue.offer(0);
        
        int res = 0;
        while (!queue.isEmpty()) {
            int u = queue.poll();
        
            for (int[] nxt : adj[u]) {
                int v = nxt[0], w1 = nxt[1];
                
                if (vis[v]) continue;
                
                vis[v] = true;
                res += w1;
                queue.offer(v);
            }
        }
        
        return res;
    }
}