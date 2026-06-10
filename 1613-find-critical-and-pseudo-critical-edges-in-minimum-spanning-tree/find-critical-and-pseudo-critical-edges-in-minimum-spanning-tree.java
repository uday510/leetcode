class Solution {
    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] oe) {
        int m = oe.length;
        int[][] ne = new int[m][4];

        for (int i = 0; i < m; i++) {
            ne[i][0] = oe[i][0];
            ne[i][1] = oe[i][1];
            ne[i][2] = oe[i][2];
            ne[i][3] = i;
        }

        Arrays.sort(ne, Comparator.comparingInt(e -> e[2]));

        int mst = kruskal(ne, n, m, -1, -1);

        List<Integer> c = new ArrayList<>();
        List<Integer> p = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            int exc = kruskal(ne, n, m, i, -1);
            if (exc > mst) {
                c.add(ne[i][3]);
            } else {
                int inc = kruskal(ne, n, m, -1, i);
                if (inc == mst) {
                    p.add(ne[i][3]);
                }
            }
        }

        return Arrays.asList(c, p);
    }

    private int kruskal(int[][] edges, int n, int m, int exc, int inc) {
        UnionFind uf = new UnionFind(n);
        int w = 0, cnt = 0;

        if (inc != -1) {
            int[] e = edges[inc];
            uf.union(e[0], e[1]);
            w += e[2];
            cnt++;
        }

        for (int i = 0; i < m; i++) {
            if (i == exc) continue;
            int[] e = edges[i];
            int u = e[0], v = e[1], w1 = e[2];

            if (!uf.connected(u, v)) {
                uf.union(u, v);
                w += w1;
                cnt++;
            }
        }

        return cnt == n - 1 ? w : Integer.MAX_VALUE;
    }
}

class UnionFind {
    int[] root, rank;

    UnionFind (int n) {
        root = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            root[i] = i;
            rank[i] = 1;
        }
    }

    int find (int x) {
        if (x == root[x]) 
            return x;
        return root[x] = find(root[x]);
    }

    void union (int x, int y) {
        int rootX = find(x), rootY = find(y);
        if (rootX == rootY) return;

        if (rank[rootX] > rank[rootY]) {
            root[rootY] = rootX;
        } else if (rank[rootY] > rank[rootX]) {
            root[rootX] = rootY;
        } else {
            rank[rootX]++;
            root[rootY] = rootX;
        }
    }

    boolean connected(int x, int y) {
        return find(x) == find(y);
    }
}