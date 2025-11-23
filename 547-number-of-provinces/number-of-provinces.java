class Solution {
    public int findCircleNum(int[][] edges) {
        int n = edges.length;
        UnionFind uf = new UnionFind(n);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int w = edges[i][j];
                if (w == 1) {
                    uf.union(i, j);
                }
            }
        }

        return uf.numComponents;
    }
}

class UnionFind {
    int[] root, rank;
    int numComponents;

    UnionFind (int n) {
        this.root = new int[n];
        this.rank = new int[n];
        numComponents = n;

        for (int i = 0; i < n; i++) {
            root[i] = i;
            rank[i] = 1;
        }
    }

    void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX == rootY) return;

        numComponents--;

        if (rank[rootX] > rank[rootY]) {
            rank[rootX]++;
            root[rootY] = rootX; 
        } else if (rank[rootY] > rank[rootX]) {
            rank[rootY]++;
            root[rootX] = rootY;
        } else {
            rank[rootX]++;
            root[rootY] = rootX; 
        }
    }

    int find(int x) {
        if (root[x] == x) return x;

        return x = find(root[x]);
    }

    boolean isConnected(int x, int y) {
        return find(x) == find(y);
    }

}