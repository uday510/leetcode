import java.util.*;

class Solution {

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        List<int[]>[] adj = new ArrayList[n];

        for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();

        for (int[] fli : flights) {
            int u = fli[0], v = fli[1], w = fli[2];

            adj[u].add(new int[]{v, w});
        }

        int[][] dists = new int[k + 2][n];
        int un = Integer.MAX_VALUE;

        for (int[] r : dists) Arrays.fill(r, un);

        Queue<int[]> pq = new PriorityQueue<>(Comparator.comparing(x -> x[1]));
        pq.offer(new int[]{src, 0, 0});
        
        pq.offer(new int[]{src, 0, 0});
        
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int u = cur[0], c = cur[1], s = cur[2];
            
            if (u == dst) return c;
            
            if (s > k || dists[s][u] < c) continue;
            
            for (int[] nxt : adj[u]) {
                int v = nxt[0], w = nxt[1];
                
                if (c + w < dists[s + 1][v]) {
                    
                    dists[s + 1][v] = c + w;
                    pq.offer(new int[]{v, c + w, s + 1});
                }
            }
        }
        
        return -1;
        
    }

}