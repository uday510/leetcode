class Solution {
    public int[] shortestAlternatingPaths(int n, int[][] red, int[][] blue) {

        List<int[]>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) 
            adj[i] = new ArrayList<>();
        
        add(0, red, adj);
        add(1, blue, adj);

        int unk = Integer.MAX_VALUE;
        int[][] dist = new int[n][2];
        for (int[] r : dist) 
            Arrays.fill(r, unk);

        Queue<int[]> queue = new ArrayDeque<>();

        dist[0][0] = dist[0][1] = 0;
        queue.offer(new int[] {0, 0, -1});

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int u = cur[0], w = cur[1], d = cur[2];

            for (int[] nxt : adj[u]) {
                int v = nxt[0], d1 = nxt[1];

                if (d != d1 && w + 1 < dist[v][d1]) {
                    dist[v][d1] = w + 1;
                    queue.offer(new int[] {v, w + 1, d1});
                }
            }
        }

        int[] res = new int[n];
        for (int idx = 0; idx < n; idx++) {
            int mn = Math.min(dist[idx][0], dist[idx][1]);
            res[idx] = mn == unk ? -1 : mn;
        }

        return res;
    }

    private void add(int k, int[][] edges, List<int[]>[] adj) {
        for (int[] e : edges) {
            adj[e[0]].add(new int[] {e[1], k});
        }
    }
}