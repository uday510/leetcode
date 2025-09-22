class Solution {
    public int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
        int minCost = kruskal(n, wells, pipes);
        
        return minCost;
    }

    private int kruskal(int n, int[] wells, int[][] pipes) {
        List<int[]> edges = new ArrayList<>();

        for (int[] e : pipes) {
            edges.add(new int[]{e[0], e[1], e[2]});
        }

        for (int v = 1; v <= n; v++) {
            edges.add(new int[] {0, v, wells[v - 1]});
        }

        edges.sort(Comparator.comparingInt(a -> a[2]));

        int minCost = 0;
        UnionFind uf = new UnionFind(n + 1);

        for (int[] e : edges) {
            int u = e[0], v = e[1], w = e[2];
            if (!uf.connected(u, v)) {
                uf.union(u, v);
                minCost += w;
            }
        }

        return minCost;
    }

    private int prims(int n, int[] wells, int[][] pipes) {
        List<int[]>[] adj = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) adj[i] = new ArrayList<>();

        for (int[] e : pipes) {
            int u = e[0], v = e[1], w = e[2];
            
            adj[u].add(new int[] {v, w});
            adj[v].add(new int[] {u, w});
        }

        for (int i = 0; i < n; i++) {
            int u = 0, v = i + 1, w = wells[i];

            adj[u].add(new int[] {v, w});
            adj[v].add(new int[] {u, w});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        boolean[] vis = new boolean[n + 1];
        int minCost = 0, visCnt = 0;

        pq.offer(new int[] {0, 0});

        while (!pq.isEmpty() && visCnt < n + 1) {
            int[] cur = pq.poll();
            int u = cur[0], w = cur[1];

            if (vis[u]) continue;
            vis[u] = true;
            minCost += w;
            visCnt++;

            for (int[] e : adj[u]) {
                int v = e[0], w1 = e[1];

                if (!vis[v]) {
                    pq.offer(new int[] {v, w1});
                }
            }
        }

        return minCost;
    }

    static class UnionFind {
        int[] root, rank;

        UnionFind(int n) {
            root = new int[n];
            rank = new int[n];

            for (int i = 0; i < n; i++) {
                root[i] = i;
                rank[i] = 1;
            }
        }
        
        void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);

            if (rootX == rootY) return;

            if (rank[rootX] > rank[rootY]) {
                root[rootY] = rootX;
            } else if (rank[rootY] > rank[rootX]) {
                root[rootX] = rootY;
            } else {
                root[rootY] = rootX;
                rank[rootX]++;
            }
        }

        int find(int x) {
            if (x == root[x]) return x;

            return root[x] = find(root[x]);
        }

        boolean connected(int x, int y) {
            return find(x) == find(y);
        }
    }
}


/**


0: [1, 1], [2, 2], [3, 2]

1: [0, 1], [2, 1]

2: [0, 2], [1, 1], [3, 1]

3: [0, 2], [2, 1]


pq: [2, 2], [3, 2], [3, 1]

vis: 1, 2, 2

0 -> 1: 1, 2 -> 1: 1, 2 -> 3: 1
minCost : 0 + 1 + 1 + 1

 */
