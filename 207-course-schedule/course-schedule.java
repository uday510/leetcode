class Solution {
    public boolean canFinish(int n, int[][] preq) {

        List<Integer>[] adj = new ArrayList[n];   
        int[] in = new int[n];

        for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();

        for (int[] e : preq) {

            int u = e[0], v = e[1];

            adj[v].add(u);
            in[u]++;
        }

        Queue<Integer> queue = new ArrayDeque<>();
        int fi = 0;

        for (int i = 0; i < n; i++) {
            if (in[i] == 0) queue.offer(i);
        }

        while (!queue.isEmpty()) {
            int u = queue.poll();
            fi++;
            
            for (int v : adj[u]) {
                if (--in[v] == 0) {
                    queue.offer(v);
                }
            }
        }

        return fi == n;
    }
}