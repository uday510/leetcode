class Solution {
    public int findCircleNum(int[][] edges) {
        int n = edges.length;
        
        UnionFind uf = new UnionFind(n);
        int components = n;

        for (int u = 0; u < n; u++) {
           for (int v = 0; v < edges[u].length; v++) {
                if (edges[u][v] == 1 && !uf.connected(u, v)) {
                    uf.union(u, v);
                    components--;
                }
           }
        }
        
        return components;
    }
    
    class UnionFind {
        int[] root, rank;
        
        UnionFind(int n) {
            root = new int[n];
            rank = new int[n];
            
            for (int i = 0; i < n; i++) {
                root[i] = i;
                rank[i] = 1;
            }
        }
        
        int find(int x) {
            if (x == root[x]) {
                return x;
            }
            
            return root[x] = find(root[x]);
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
                root[rootY] = rootX;
                rank[rootX]++;
            }
        }
        
        boolean connected(int x, int y) {
            return find(x) == find(y);
        }
    }
}