class Solution {
    public int[] findOrder(int n, int[][] pre) {
        List<Integer>[] adj = new ArrayList[n];
        int[] in = new int[n];

        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int[] p : pre) {
            int u = p[1], v = p[0];
            adj[u].add(v);
            in[v]++;
        }

        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (in[i] == 0) 
                queue.offer(i);
        }

        int idx = 0;
        int[] res = new int[n];
        while (!queue.isEmpty()) {
            int u = queue.poll();
            res[idx++] = u;
            for (int v : adj[u]) {
                if (--in[v] == 0) {
                    queue.offer(v);
                }
            }
        }

        return idx == n ? res : new int[] {};
    }
}