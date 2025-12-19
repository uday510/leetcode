class Solution {
    public List<Integer> findAllPeople(int n, int[][] edges, int src) {
        Arrays.sort(edges, Comparator.comparingInt(e -> e[2]));

        DSU dsu = new DSU(n);
        dsu.union(0, src);
        
        int u, v;
        for (int idx = 0; idx < edges.length;) {
            int w = edges[idx][2];
            List<int[]> batch = new ArrayList<>();

            
            while (idx < edges.length && w == edges[idx][2]) {
                u = edges[idx][0]; v = edges[idx][1];
                dsu.union(u, v);
                batch.add(edges[idx]);
                idx++;
            }

            for (int[] b : batch) {
                u = b[0]; v = b[1];
                if (!dsu.connected(src, u)) {
                    dsu.reset(u);
                    dsu.reset(v);
                }
            }
        }

        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (dsu.connected(src, i)) {
                res.add(i);
            }
        }

        return res;
    }
}

class DSU {
    int[] root, rank;
    
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

        if (rootX == rootY) return;

        if (rank[rootX] > rank[rootY]) {
            root[rootY] = rootX;
        } else if (rank[rootY] > rank[rootX]) {
            root[rootX] = rootY;
        } else {
            rank[rootX] += 1;
            root[rootY] = rootX;
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

    void reset(int x) {
        root[x] = x;
        rank[x] = 1;
    }
}