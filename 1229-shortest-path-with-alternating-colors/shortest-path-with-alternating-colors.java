class Solution {

    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {

        List<int[]>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++)
            adj[i] = new ArrayList<>();

        add(0, redEdges, adj);
        add(1, blueEdges, adj);

        int[][] dist = new int[n][2];
        int unk = Integer.MAX_VALUE;

        for (int[] r : dist)
                Arrays.fill(r, unk);

        Queue<int[]> queue = new ArrayDeque<>();
        dist[0][0] = dist[0][1] = 0;
        queue.offer(new int[] {0, 0, -1});

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int u = cur[0], w = cur[1], c = cur[2];

            for (int[] nxt : adj[u]) {
                int v = nxt[0], c1 = nxt[1];
                if (c != c1 && w + 1 < dist[v][c1]) {
                    dist[v][c1] = w + 1;
                    queue.offer(new int[] {v, w + 1, c1});
                }
            }
        }

        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = Math.min(dist[i][0], dist[i][1]);
            res[i] = res[i] == unk ? -1 : res[i];
        }
        
        return res;
    }

    private void add(int k, int[][] edges, List<int[]>[] adj) {

       for (int[] e : edges) {
           int u = e[0], v = e[1];
           adj[u].add(new int[] {v, k});
       }

    }

}