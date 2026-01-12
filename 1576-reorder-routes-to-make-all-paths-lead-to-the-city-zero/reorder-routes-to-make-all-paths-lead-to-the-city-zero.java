class Solution {
    public int minReorder(int n, int[][] cons) {
        
        List<int[]>[] adj = new ArrayList[n];

        for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();

        for (int[] con : cons) {
            int u = con[0], v = con[1];

            adj[u].add(new int[] {v, 1});
            adj[v].add(new int[] {u, 0});

        }

        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] vis = new boolean[n];

        queue.offer(0);
        int dist = 0;

        vis[0] = true;
        
        while (!queue.isEmpty()) {
            int u = queue.poll();

            for (int[] nxt : adj[u]) {
                int v = nxt[0], w = nxt[1];

                if (vis[v]) continue;

                System.out.println(u + " -> " + v + ", " + w);

                dist += w;
                vis[v] = true;
                queue.offer(v);
            }
        }

        return dist;
    }
}

/**

0 -> 1:1, 4:0

1 -> 0:0, 3:1

2 -> 3:1

3 -> 1:0, 2:0

4 -> 0:1, 5:1

5 -> 4:0

---

min: 0 + 0 + 1 + 1

vis: 0, 1, 4, 3

queue:  3

cur: 0


 */