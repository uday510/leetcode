class Solution {

    public int findCircleNum(int[][] edges) {

        int n = edges.length;
        boolean[] vis = new boolean[n];
        int total = 0;
        
        for (int i = 0; i < n; i++) {
            
            if (!vis[i]) {
                total++;
                bfs(i, edges, vis);
            }
        }
        
        return total;
    }
    
    private void bfs(int st, int[][] edges, boolean[] vis) {
        
        Queue<Integer> queue = new ArrayDeque<>();
        
        queue.offer(st);
        
        while (!queue.isEmpty()) {
            int u = queue.poll();
            
            vis[u] = true;
            
            for (int v = 0; v < edges[u].length; v++) {
                
                if (u == v || vis[v] || edges[u][v] == 0) continue;
                
                queue.offer(v);
            }
        }
    }


}