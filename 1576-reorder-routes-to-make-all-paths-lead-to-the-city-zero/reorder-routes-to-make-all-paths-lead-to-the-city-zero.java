class Solution {
    public int minReorder(int n, int[][] edges) {
        
        List<int[]>[] adjList = new ArrayList[n];
        for (int i = 0; i < n; i++) adjList[i] = new ArrayList<>();

        for (int[] e : edges) {
            int u = e[0], v = e[1];
            adjList[u].add(new int[]{v, 1});
            adjList[v].add(new int[]{u, 0});
        }

        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] vis = new boolean[n];
        queue.offer(0);
        int dist = 0;
        vis[0] = true;

        while (!queue.isEmpty()) {
            int u = queue.poll();

            for (int[] nxt : adjList[u]) {
                int v = nxt[0], w = nxt[1];

                if (vis[v]) continue;

                dist += w;
                vis[v] = true;
                queue.offer(v);
            }
        }

        return dist;
    }
}