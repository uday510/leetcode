class Solution {
    static int THREADS = 10;
    public boolean canVisitAllRooms(List<List<Integer>> edges) {
        ExecutorService ex = Executors.newFixedThreadPool(THREADS);
        Callable<Boolean> cl = () -> {
            Thread.sleep(5000);
            boolean res = bfs(edges);
            return res;
        };

        List<Callable<Boolean>> cls = new ArrayList<>();
        for (int i = 0; i < THREADS; ++i) cls.add(() -> bfs(edges));

        try {
            List<Future<Boolean>> fs = ex.invokeAll(cls);
            ex.shutdown();
            
            for (var f : fs) {
                if (!f.get()) return false;
            }
            
            return true;
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