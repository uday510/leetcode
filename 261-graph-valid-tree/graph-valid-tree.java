class Solution {
    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1) return false;
        DSU dsu = new DSU(n);

        for (int[] e : edges) {
            int u = e[0], v = e[1];

            if (dsu.isConnected(u, v)) {
                return false;
            }

            dsu.union(u, v);
        }
        
        return true;
    }
}

class DSU {
    int[] root;
    int[] rank;

    DSU (int n) {
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

        if (rootX == rootY)
            return;
        
        if (rank[rootX] > rank[rootY]) {
            root[rootY] = rootX;
        } else if (rank[rootY] > rank[rootX]) {
            root[rootX] = rootY;
        } else {
            rank[rootX]++;
            root[rootY] = rootX;
        }

    }
    int find(int x) {
        if (x == root[x])
            return x;
        return root[x] = find(root[x]);
    }

    boolean isConnected(int x, int y) {
        return find(x) == find(y);
    }
}