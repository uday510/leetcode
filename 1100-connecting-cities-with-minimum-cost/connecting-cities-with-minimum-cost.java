class Solution {
    
    public int minimumCost(int n, int[][] cons) {
        List<int[]>[] adj = new ArrayList[n + 1];
        boolean[] inMST = new boolean[n + 1];
        
        for (int i = 1; i <= n; i++) adj[i] = new ArrayList<>();
        
        for (int[] c : cons) {
            int u = c[0], v = c[1], w = c[2];
            
            adj[u].add(new int[] {v, w});
            adj[v].add(new int[] {u, w});
        }

        Queue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt( k -> k[1]));
        pq.offer(new int[] {1, 0});
        int vis = 0, total = 0;
                
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int u = cur[0], w = cur[1];
            
            if (inMST[u]) continue;
            
            inMST[u] = true;
            vis++;
            total += w;
            
            for (int[] nxt : adj[u]) {
                int v = nxt[0], w1 = nxt[1];
                
                if (!inMST[v]) {
                    pq.offer(new int[]{v, w1});
                }
            }

        }
        
        return vis == n ? total : -1;
    }
}