class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
         DSU dsu = new DSU(n);
        for(int[] edge : edges) {
            dsu.union(edge[0], edge[1]);
        }
        return dsu.isConnected(source, destination);
    }
    class DSU {
        int[] parent;
        int[] rank;

        public DSU(int n) {
            parent = new int[n];
            rank = new int[n];
            int i = 0;
            
            for(; i < n;) {
                parent[i] = i;
                rank[i] = 1;
                ++i;
            }
        }

        public int find(int x) {
            for (; x != parent[x];) {
                parent[x] = parent[parent[x]];
                x = parent[x];
            }
            return x;
        }

        public void union(int x, int y) {
            int px = find(x);
            int py = find(y);
            if (px != py) {
                if (rank[px] > rank[py]) {
                    parent[py] = px;
                } else if (rank[py] > rank[px]) {
                    parent[px] = py;
                } else {
                    parent[px] = py;
                    ++rank[py];
                }
            }
        }

        public boolean isConnected(int x, int y) {
            return find(x) == find(y);
        }
    }
}