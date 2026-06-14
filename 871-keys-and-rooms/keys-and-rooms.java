class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> adj) {
        int n = adj.size();
        boolean[] vis = new boolean[n];
        int visited = 0;
    
        Queue<Integer> queue = new ArrayDeque<>();
        vis[0] = true;
        queue.offer(0);

        while (!queue.isEmpty() && visited != n) {
            int u = queue.poll();
            visited++;

            for (int v : adj.get(u)) {
                if (vis[v]) continue;
                
                vis[v] = true;
                queue.offer(v);
            }
        }
        
        return visited == n;
        
    }
}

/**


0 -> 1, 3
1 -> 0, 1, 3
2 -> 2
3 -> 0




 */