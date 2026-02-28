class Solution {

    public int collectTheCoins(int[] coins, int[][] edges) {
        
        int n = coins.length;
        List<Integer>[] adj = new ArrayList[n];
        int[] degree = new int[n];

        for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();

        for (int[] e : edges) {
            int u = e[0], v = e[1];
            adj[u].add(v);
            adj[v].add(u);
            degree[u]++;
            degree[v]++;
        }

        Queue<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            if (degree[i] == 1 && coins[i] == 0) { // leaf with no coins
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int u = queue.poll();
            degree[u]--;

            for (int v : adj[u]) {
                if (degree[v] > 0) {
                    degree[v]--;

                    if (degree[v] == 1 && coins[v] == 0) {
                        queue.offer(v);
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (degree[i] == 1) {
                queue.offer(i);
            }
        }

        for (int r = 0; r < 2; r++) {
            int sz = queue.size();

            while (sz-- > 0) {
                int u = queue.poll();
                degree[u]--;

                for (int v : adj[u]) {
                    if (degree[v] > 0) {
                        degree[v]--;
                        if (degree[v] == 1) {
                            queue.offer(v);
                        }
                    }
                }
            }
            
        }

        int rm = 0;
        for (int[] e : edges) {
            if (degree[e[0]] > 0 && degree[e[1]] > 0) {
                rm++;
            }
        }

        return rm * 2;
    }
}