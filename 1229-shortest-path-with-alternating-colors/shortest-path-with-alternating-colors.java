class Solution {
    public int[] shortestAlternatingPaths(int n, int[][] r1, int[][] b1) {
        

        List<int[]>[] adj = new ArrayList[n];

        for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();

        add(n, 0, r1, adj);
        add(n, 1, b1, adj);

        Queue<int[]> queue = new ArrayDeque<>();
        int[][] dist = new int[n][2];
        for (int[] r : dist) Arrays.fill(r, (int) 1e9);

        dist[0][0] = dist[0][1] = 0;
        queue.offer(new int[] {0, 0, -1});

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int u = cur[0], w = cur[1], c1 = cur[2];

            for (int[] nxt : adj[u]) {
                int v = nxt[0], c2 = nxt[1];
                if (c1 != c2 && w + 1 < dist[v][c2]) {
                    dist[v][c2] = w + 1;
                    queue.offer(new int[] {v, w + 1, c2});
                }
            }
        }

        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = Math.min(dist[i][0], dist[i][1]);
            res[i] = res[i] == (int) 1e9 ? -1 : res[i];
        }

        return res;
    }

    private void add(int n, int k, int[][] edges, List<int[]>[] adj) {

        for (int[] e : edges) {
            int u = e[0], v = e[1];
            adj[u].add(new int[] {v, k});
        }
    }
}


/**

0 -> {1, 0}
1 ->
2 -> {1, 1}






 */