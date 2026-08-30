class Solution {
    public boolean canFinish(int n, int[][] pre) {
        List<Integer>[] adj = new ArrayList[n];
        int[] in = new int[n];

        for (int i = 0; i < n; i++) 
            adj[i] = new ArrayList<>();
        
        for (int[] p : pre) {
            int u = p[1], v = p[0];
            adj[u].add(v);
            in[v]++;
        }

        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (in[i] == 0) {
                queue.offer(i);
            }
        }

        int total = 0;
        while (!queue.isEmpty()) {
            if(++total == n)
                return true;

            int u = queue.poll();
            for (int v : adj[u]) {
                if (--in[v] == 0)   
                    queue.offer(v);
            }
        }

        return false;
    }
}