class Solution {
    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        
        int m = queries.length;
        DSU dsu = new DSU(n);

        for (int i = 0; i < n - 1; i++) {
            if (Math.abs(nums[i] - nums[i + 1]) <= maxDiff)
                dsu.union(i, i + 1);
        }

        boolean[] res = new boolean[m];

        for (int i = 0; i < m; i++) {
            int[] q = queries[i];

            res[i] = dsu.connected(q[0], q[1]);
        }

        return res;
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
        int rx = find(x);
        int ry = find(y);

        if (rx == ry)
            return;

        if (rank[rx] > rank[ry]) {
            root[ry] = rx; 
        } else if (rank[ry] > rank[rx]) {
            root[rx] = ry;
        } else {
            rank[rx]++;
            root[ry] = rx;
        }
        
    }

    int find(int x) {
        if (x == root[x])
            return x;
        
        return root[x] = find(root[x]);
    }

    boolean connected(int x, int y) {
        return find(x) == find(y);
    }
}