class Solution {
    public int numOfMinutes(int n, int h, int[] mng, int[] infrm) {
        
        List<Integer>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++)
            adj[i] = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            if (mng[i] != -1) {
                adj[mng[i]].add(i);
            }
        }

        int mx = -1;
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {h, infrm[h]});

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int u = cur[0], w = cur[1];

            mx = Math.max(mx, w);
            for (int nxt : adj[u]) {
                queue.offer(new int[] {nxt, w + infrm[nxt]});
            }
        }
        
        return mx;
    }
}