class Solution {
    public int findCircleNum(int[][] edges) {
        
        int n = edges.length;
        boolean[] vis = new boolean[n];
        int total = 0;

        for (int i = 0; i < n; i++) {
            if (vis[i]) continue;

            total++;
            bfs(i, edges, vis);
        }

        return total;
    }

    private void bfs(int st, int[][] edges, boolean[] vis) {

        vis[st] = true;
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(st);

        while (!queue.isEmpty()) {
            int u = queue.poll();

            for (int i = 0; i < edges[u].length; i++) {
                boolean ok = i != u && edges[u][i] == 1 && !vis[i];

                if (!ok) continue;

                vis[i] = true;
                queue.offer(i);
            }
        }
    }
}