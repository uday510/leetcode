import java.util.*;

class Solution {
    private static final int ALICE = 1;
    private static final int BOB = 2;
    private static final int BOTH = 3;

    public int maxNumEdgesToRemove(int n, int[][] edges) {
        DSU alice = new DSU(n + 1);
        DSU bob = new DSU(n + 1);
        
        int res = 0;

        for (int type = BOTH; type > 0; --type) {
            for (int[] edge : edges) {
                int t = edge[0];
                int u = edge[1];
                int v = edge[2];

                if (t != type) {
                    continue;
                }

                if (t == ALICE) {
                    if (alice.connected(u, v)) {
                        res++;
                    } else {
                        alice.union(u, v);
                    }
                } else if (t == BOB) {
                    if (bob.connected(u, v)) {
                        res++;
                    } else {
                        bob.union(u, v);
                    }
                } else {
                    if (alice.connected(u, v) && bob.connected(u, v)) {
                        res++;
                    } else {
                        alice.union(u, v);
                        bob.union(u, v);
                    }
                }
            }
        }

        if (alice.components() != 1 || bob.components() != 1) {
            return -1;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 4;
        int[][] edges = {
            {3, 1, 2},
            {3, 2, 3},
            {1, 1, 3},
            {1, 2, 4},
            {1, 1, 4},
            {2, 3, 4}
        };
        System.out.println(solution.maxNumEdgesToRemove(n, edges));  // Expected output: 2
    }
}

class DSU {
    private int[] root;
    private int[] rank;

    public DSU(int n) {
        root = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; ++i) {
            root[i] = i;
            rank[i] = 1;
        }
    }

    public int find(int x) {
        if (x == root[x]) {
            return x;
        }
        return root[x] = find(root[x]);  // Path compression
    }

    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) {
            if (rank[rootX] > rank[rootY]) {
                root[rootY] = rootX;
            } else if (rank[rootX] < rank[rootY]) {
                root[rootX] = rootY;
            } else {
                root[rootY] = rootX;
                rank[rootX]++;
            }
        }
    }

    public boolean connected(int x, int y) {
        return find(x) == find(y);
    }

    public int components() {
        int count = 0;
        for (int i = 1; i < root.length; ++i) {
            if (root[i] == i) {
                count++;
            }
        }
        return count;
    }
}