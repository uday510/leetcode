class Solution {

    public int numOfMinutes(int n, int st, int[] manager, int[] informTime) {

        List<int[]>[] adj = new ArrayList[n];
        for (int idx = 0; idx < n; idx++)
            adj[idx] = new ArrayList<>();
        
        for (int idx = 0; idx < n; idx++) {
            if (manager[idx] != -1) {
                adj[manager[idx]].add(new int[] {idx, informTime[idx]});
            }
        }
        
        int mx = -1;
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {st, informTime[st]});
        
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int u = cur[0], w = cur[1];
            
            mx = Math.max(mx, w);
            for (int[] nxt : adj[u]) {
                int v = nxt[0], w1 = nxt[1];
                queue.offer(new int[] {v, w + w1});
            }
        }
        
        return mx;
    }

}