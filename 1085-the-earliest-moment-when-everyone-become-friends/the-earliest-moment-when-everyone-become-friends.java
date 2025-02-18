class Solution {
    public int earliestAcq(int[][] logs, int n) {
        Arrays.sort(logs, Comparator.comparingInt(log -> log[0]));
        UnionFind uf = new UnionFind(n);
        int numGroups = n;
        
        for (int[] log : logs) {
            numGroups -= uf.union(log[1], log[2]);
            if (numGroups == 1) return log[0];
        }

        return -1;
    }

    class UnionFind {
        int[] root;
        int[] rank;

        UnionFind (int n) {
            root = new int[n];
            rank = new int[n];

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