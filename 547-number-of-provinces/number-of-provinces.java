class Solution {

    int[][] edges;
    int n;
    boolean[] vis;

    public int findCircleNum(int[][] edges) {
        this.edges = edges;
        this.n = edges.length;
        vis = new boolean[n];
        int provinces = 0;

        for (int i = 0; i < n; i++) {
            if (vis[i]) continue;

            provinces++;
            bfs(i);
        }

        return provinces;
    }

    private void bfs(int st) {
        Queue<Integer> queue = new ArrayDeque<>();
        vis[st] = true;
        queue.offer(st);

        while (!queue.isEmpty()) {
            int u = queue.poll();

            for (int v = 0; v < n; v++) {
                if (edges[u][v] == 0 || vis[v]) continue;

                vis[v] = true;
                queue.offer(v);
            }
        }

    }
}