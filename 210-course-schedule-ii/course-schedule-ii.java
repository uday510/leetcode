class Solution {
    public int[] findOrder(int n, int[][] pre) {
        List<Integer>[] adj = new ArrayList[n];
        Queue<Integer> queue = new ArrayDeque<>();
        int[] in = new int[n];

        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int[] p : pre) {
            int u = p[1], v = p[0];
            adj[u].add(v);
            in[v]++;
        }

        for (int i = 0; i < n; i++) {
            if (in[i] == 0) {
                queue.offer(i);
            }
        }

        int total = 0, idx = 0;
        int[] res = new int[n];
        
        while (!queue.isEmpty()) {
            int u = queue.poll();
            total++;
            res[idx++] = u;
            for (int v : adj[u]) {
                if (--in[v] == 0) {
                    queue.offer(v);
                }
            }
        }

        return total == n ? res : new int[] {};
    }
}