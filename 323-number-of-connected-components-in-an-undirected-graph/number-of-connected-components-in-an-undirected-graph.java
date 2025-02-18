class Solution {
    public int countComponents(int n, int[][] edges) {
        UnionFind uf = new UnionFind(n);
        int numComponents = n;

        for (int[] edge : edges) {
            numComponents -= uf.union(edge[0], edge[1]);
        }

        return numComponents;
    }
    class UnionFind {
        int[] root;
        int[] rank;

        UnionFind(int n) {
            this.root = new int[n];
            this.rank = new int[n];

            for (int idx = 0; idx < n; ++idx) {
                root[idx] = idx;
                rank[idx] = 1;
            }
        }

        int union(int x, int y) {
            int rootX = find(root[x]);
            int rootY = find(root[y]);

            if (rootX == rootY) {
                return 0;
            }

            if (rank[rootX] > rank[rootY]) {
                root[rootY] = rootX; 
            } else if (rank[rootY] > rank[rootX]) {
                root[rootX] = rootY;
            } else {
                root[rootY] = rootX;
                rank[rootX] += 1;
            }
            return 1;
        }

        int find(int x) {
            if (x == root[x]) {
                return x;
            }

            return root[x] = find(root[x]);
        }
    }
}