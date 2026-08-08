class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> adj) {
        
        int n = adj.size();
        boolean[] vis = new boolean[n];
        Queue<Integer> queue = new ArrayDeque<>();

        vis[0] = true;
        queue.offer(0);

        int visited = 0;

        while (!queue.isEmpty()) {
            
            int cur = queue.poll();
            visited++;

            for (int nxt : adj.get(cur)) {
                if (vis[nxt]) continue;

                vis[nxt] = true;
                queue.offer(nxt);
            }
        }

        return visited == n;
    }
}