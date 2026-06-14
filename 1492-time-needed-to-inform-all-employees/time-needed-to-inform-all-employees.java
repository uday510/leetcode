class Solution {
    public int numOfMinutes(int n, int h, int[] m, int[] in) {
        List<Integer>[] adj = new ArrayList[n];

        for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (m[i] != -1) {
                adj[m[i]].add(i);
            }
        }

        Queue<int[]> queue = new ArrayDeque<>();
        int mx = 0;
        
        queue.offer(new int[]{h, 0});
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int u = cur[0], w = cur[1];

            mx = Math.max(mx, w);
            
            for (int v : adj[u]) {
                queue.offer(new int[] {v, w + in[u]});
            }
        }

        return mx;

    }
}