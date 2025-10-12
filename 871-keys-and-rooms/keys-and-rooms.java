class Solution {

    public boolean canVisitAllRooms(List<List<Integer>> edges) {
        ExecutorService ex = Executors.newFixedThreadPool((int) 1e9);
        Callable<Boolean> cl = () -> bfs(edges);
        Future<Boolean> f = ex.submit(cl);

        try {
            boolean res = f.get();
            ex.shutdown();
            return res;
        } catch(Exception ignored) {
            ex.shutdown();
            return false;
        }
    }
    public boolean bfs(List<List<Integer>> edges) {
        boolean[] vis = new boolean[edges.size()];
        int cnt = 0;

        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(0);
        vis[0] = true;

        while (!queue.isEmpty()) {
            int u = queue.poll();
            cnt++;

            for (int v : edges.get(u)) {
                if(vis[v]) continue;
                vis[v] = true;
                queue.offer(v);
            }
        }

        return cnt == edges.size();
    }
}