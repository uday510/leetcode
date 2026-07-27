class Solution {
    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1) return false;
        
        DSU dsu = new DSU(n);

        for (int[] e : edges) {
            int u = e[0], v = e[1];

            if (dsu.isConnected(u, v)) 
                return false;
            
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

    int find(int x) {
        if (x == root[x])
            return x;
        return root[x] = find(root[x]);
    }

    void union(int x, int y) {
        int rx = find(x);
        int ry = find(y);

        if (rx == ry) return;

        if (rank[rx] > rank[ry]) {
            root[ry] = rx;
        } else if (rank[ry] > rank[rx]) {
            root[rx] = ry;
        } else {
            rank[rx]++;
            root[ry] = rx;
        }
    }

    boolean isConnected(int x, int y) {
        return find(x) == find(y);
    }
}