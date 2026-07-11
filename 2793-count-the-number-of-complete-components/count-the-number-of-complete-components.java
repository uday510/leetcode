class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        
        DSU dsu = new DSU(n);
        
        for (int[] e : edges) {
            int u = e[0], v = e[1];
            dsu.union(u, v);
        }

        Map<Integer, Integer> cnt = new HashMap<>();
        for (int[] e : edges) {
            int r = dsu.find(e[0]);
            cnt.merge(r, 1, Integer::sum);
        }

        int total = 0;
        for (int i = 0; i < n; i++) {
            if (dsu.find(i) != i) continue;
            int k = dsu.getSize(i);
            int m = cnt.getOrDefault(i, 0);
            total += (m == k * (k - 1) / 2) ? 1 : 0;
        }

        return total;
    }
}

class DSU {
    private int[] root;
    private int[] rank;
    private int[] size;
    private Map<Integer, Integer> map;

    DSU (int n) {
        root = new int[n];
        rank = new int[n];
        size = new int[n];

        for(int i = 0; i < n; i++) {
            root[i] = i;
            rank[i] = 1;
            size[i] = 1;
        }
    }

    void union(int x, int y) {
        int rx = find(x);
        int ry = find(y);

        if (rx == ry)
            return;
        
        if (rank[rx] > rank[ry]) {
            size[rx] += size[ry];
            root[ry] = rx;
        } else if (rank[rx] < rank[ry]) {
            size[ry] += size[rx];
            root[rx] = ry;
        } else {
            size[rx] += size[ry];
            root[ry] = rx;
            rank[rx]++;
        }

    }

    int find(int x) {
        if (x == root[x])
            return x;
        
        return root[x] = find(root[x]);
    }

    int getSize(int x) {
        return size[find(x)];
    }
}