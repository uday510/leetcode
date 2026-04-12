class Solution {

    private List<Integer>[] adj;
    private int n;
    private int[] dist, parent;

    public int findShortestCycle(int n, int[][] edges) {
        adj = new ArrayList[n];
        dist = new int[n];
        parent = new int[n];

        this.n = n;

        for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();

        for (int[] e : edges) {
            int u = e[0], v = e[1];

            adj[u].add(v);
            adj[v].add(u);
        }

        int d = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            int cur = bfs(i);

            d = Math.min(d, cur);
        }

        return d == Integer.MAX_VALUE ? -1 : d;
    }

    private int bfs(int st) {
        Queue<Integer> queue = new ArrayDeque<>();
        
        for (int i = 0; i < n; i++) dist[i] = parent[i] = -1;
        
        dist[st] = 0;

        queue.offer(st);
        
        int min = Integer.MAX_VALUE;

        while (!queue.isEmpty()) {
           int u = queue.poll();

           for (int v : adj[u]) {

               if (dist[v] == -1) {
                   dist[v] = dist[u] + 1;
                   parent[v] = u;
                   queue.offer(v);
               } else if (v != parent[u]) {
                   min = Math.min(min, dist[u] + dist[v] + 1);

                   if (min == 3) return 3;
               }
           }
        }

        return min;
    }
}