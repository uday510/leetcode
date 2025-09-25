class Solution {
    public int numSimilarGroups(String[] strs) {
        int n = strs.length;
        UnionFind uf = new UnionFind(n);

        for (int i = 0; i < n; i++) {
            String s1 = strs[i];
            for (int j = i + 1; j < n; j++) {
                String s2 = strs[j];
                int d = 0;

                for (int k = 0; k < s1.length() && d < 3; k++) {
                    d += s1.charAt(k) != s2.charAt(k) ? 1 : 0;
                }

                if (d <= 2) {
                    uf.union(i, j);
                }
            }
        }

        return uf.getComponents();
    }
}

class UnionFind {
    private final int[] root;
    // Use a rank array to record the height of each vertex, i.e., the "rank" of each vertex.
    private final int[] rank;

    private int components;

    public UnionFind(int size) {
        root = new int[size];
        rank = new int[size];
        components = size;

        for (int i = 0; i < size; i++) {
            root[i] = i;
            rank[i] = 1;  // The initial "rank" of each vertex is 1, because each of them is
            // a standalone vertex with no connection to other vertices.
        }
    }

    // The find function here is the same as that in the disjoint set with path compression.
    public int find(int x) {
        if (x == root[x]) return x;

        // Some ranks may become obsolete so they are not updated
        return root[x] = find(root[x]);
    }

    // The union function with union by rank
    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX == rootY) return;

        if (rank[rootX] > rank[rootY]) {
            root[rootY] = rootX;
        } else if (rank[rootX] < rank[rootY]) {
            root[rootX] = rootY;
        } else {
            root[rootY] = rootX;
            rank[rootX] += 1;
        }

        components--;
    }

    public boolean connected(int x, int y) {
        return find(x) == find(y);
    }

    public int getComponents() {
        return components;
    }
}

/**


t -> t, r, a, s


 */