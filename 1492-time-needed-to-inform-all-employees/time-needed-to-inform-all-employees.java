class Solution {
    public int numOfMinutes(int n, int st, int[] mng, int[] infrm) {
        List<Integer>[] adj = new ArrayList[n];

        for (int i = 0; i < n; i++)
            adj[i] = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (mng[i] != -1) {
                adj[mng[i]].add(i);
            }
        }

        Queue<int[]> queue = new ArrayDeque<>();
        int mx = 0;

        queue.offer(new int[] {st, infrm[st]});
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int u = cur[0], w = cur[1];

            mx = Math.max(mx, w);
            for (int v : adj[u]) {
                queue.offer(new int[] {v, w + infrm[v]});
            }
        }

        return mx;
    }
}