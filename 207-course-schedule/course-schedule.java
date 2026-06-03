class Solution {
    public boolean canFinish(int n, int[][] pre) {
        
        List<Integer>[] adj = new ArrayList[n];
        int[] inc = new int[n];

        for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();

        for (int[] p : pre) {
            int u = p[0], v = p[1];
            adj[v].add(u);
            inc[u]++;
        }

        Queue<Integer> queue = new ArrayDeque<>();
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            if (inc[i] == 0) queue.offer(i);
        }

        while (!queue.isEmpty()) {
            int u = queue.poll();
            cnt++;

            if (cnt == n) return true;

            for (int v : adj[u]) {
                if (--inc[v] == 0) queue.offer(v);
            }
        }

        return cnt == n;
    }
}