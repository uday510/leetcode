class Solution {

    public int largestPathValue(String colors, int[][] edges) {
        
        int n = colors.length();
        List<Integer>[] adj = new ArrayList[n];
        
        for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();
        
        int[] in = new int[n];
        for (int[] e : edges) {
            adj[e[0]].add(e[1]);
            in[e[1]]++;
        }

        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (in[i] == 0) queue.offer(i);
        }
        
        int vis = 0, mx = 0;
        int[][] dp = new int[n][26];
        
        while (!queue.isEmpty()) {
            int u = queue.poll();
            vis++;
            
            int colorIdx = colors.charAt(u) - 'a';
            dp[u][colorIdx]++;
            
            mx = Math.max(mx, dp[u][colorIdx]);
            
            for (int v : adj[u]) {
                for (int c = 0; c < 26; c++) {
                    dp[v][c] = Math.max(dp[v][c], dp[u][c]);
                }
                
                if (--in[v] == 0) {
                    queue.offer(v);
                }
            }
        }
        
        return vis == n ? mx : -1;
    }
}