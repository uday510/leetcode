class Solution {
    public int findCircleNum(int[][] edges) {
        int n = edges.length;
        boolean[] vis = new boolean[n];
        int provinces = 0;

        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                provinces++;
                bfs(i, vis, edges);
            }
        }

        return provinces;
    }

    private void bfs(int st, boolean[] vis, int[][] edges) {
        vis[st] = true;

        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(st);

        while (!queue.isEmpty()) {
            int cur = queue.poll();

           for (int i = 0; i < edges[cur].length; i++) {
                if (edges[cur][i] == 1 && !vis[i]) {
                    vis[i] = true;
                    queue.offer(i);
                }
           }
           
        }
    }
}