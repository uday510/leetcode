class Solution {
    public int[] findOrder(int n, int[][] preq) {

        List<Integer>[] adj = new ArrayList[n];

        for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();

        int[] in = new int[n];

        for (int[] p : preq) {
            int u = p[0], v = p[1];
            adj[v].add(u);
            in[u]++;
        }

        Queue<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            if (in[i] == 0) queue.offer(i);
        }

        int[] res = new int[n];
        int fi = 0, idx = 0;

        while (!queue.isEmpty()) {
            int u = queue.poll();
            fi++;
            res[idx++] = u;

            for (int v : adj[u]) {
                if (--in[v] == 0) {
                    queue.offer(v);
                }
            }
        }

        return fi == n ? res : new int[] {};
        
    }
}