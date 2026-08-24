class Solution {
    public boolean isBipartite(int[][] graph) {
        
        int n = graph.length;
        int[] color = new int[n];

        for (int i = 0; i < n; i++) {
            if (color[i] != 0)  
                continue;

            Queue<Integer> queue = new ArrayDeque<>();
            color[i] = 1;
            queue.offer(i);

            while (!queue.isEmpty()) {
                int u = queue.poll();

                for (int v : graph[u]) {
                
                    if (color[u] == color[v]) 
                        return false;
                    
                    if (color[v] != 0)
                        continue;
                    
                    color[v] = -color[u];
                    queue.offer(v);
                }
            }
        }

        return true;
    }
}