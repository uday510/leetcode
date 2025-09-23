class Solution {
    public int minCostConnectPoints(int[][] points) {
        int minCost = kruskal(points);
        return minCost;
    }

    private int prims(int[][] points) {
        int n = points.length;
        List<int[]>[] edges = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            edges[i] = new ArrayList<>();
            int[] p1 = points[i];
            for (int j = i + 1; j < n; j++) {
                int[] p2 = points[j];
                int d = Math.abs(p1[0] - p2[0]) + Math.abs(p1[1] - p2[1]);
                edges[i].add(new int[] {j, d});
            }
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        pq.offer(new int[] {0, 0, 0});

        boolean[] vis = new boolean[n];
        int edgesVis = 0, minCost = 0;

        while(!pq.isEmpty() && edgesVis < n - 1) {
            int[] cur = pq.poll();
            int u = cur[0], v = cur[1], w = cur[2];

            if (vis[v]) continue;
            vis[v] = true;
            minCost += w;
            edgesVis++;

            for (int[] nxt : edges[v]) {
                int v1 = nxt[0], w1 = nxt[1]; 
                if (vis[v1]) continue;

                pq.offer(new int[] {v, v1, w1});
            }
        }

        return minCost;
    }

    private int kruskal(int[][] points) {
        int n = points.length;

        UnionFind uf = new UnionFind(n);

        List<Edge> edges = new ArrayList<>();

        for (int u = 0; u < n; u++) {
            int[] c1 = points[u];
            for (int v = u + 1; v < n; v++) {
                int[] c2 = points[v];
                int w = Math.abs(c1[0] - c2[0]) + Math.abs(c1[1] - c2[1]);

                edges.add(new Edge(u, v, w));
            }
        }

        Collections.sort(edges, Comparator.comparingInt(a -> a.w));
        int minCost = 0, edgesUsed = 0;

        for (int i = 0; i < edges.size() && edgesUsed < n - 1; i++) {
            Edge e = edges.get(i);
            int u = e.u, v = e.v, w = e.w;

            if (!uf.connected(u, v)) {
                uf.union(u, v);
                minCost += w;
                edgesUsed++;
            }
        }

        return minCost;
    }
}

class Edge {
    int u, v, w;

    Edge(int u, int v, int w) {
        this.u = u;
        this.v = v;
        this.w = w;
    }

}

class UnionFind {
    int[] rank, root;

    UnionFind(int n) {
        rank = new int[n];
        root = new int[n];

        for (int i = 0; i < n; i++) {
            rank[i] = 1;
            root[i] = i;
        }
    }

    int find(int x) {
        if (x == root[x]) return x;

        return root[x] = find(root[x]);
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

    boolean connected(int x, int y) {
        return find(x) == find(y);
    }    
}