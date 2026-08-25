class Solution {
    public int numSimilarGroups(String[] strs) {
        
        int n = strs.length;
        DSU dsu = new DSU(n);

        for (int i = 0; i < n; i++) {
            String s1 = strs[i];

            for (int j = i + 1; j < n; j++) {
                String s2 = strs[j];

                int d = 0;

                for (int k = 0; k < Math.min(s1.length(), s2.length()) && d < 3; k++) {
                    d += s1.charAt(k) == s2.charAt(k) ? 0 : 1;
                }

                if (d <= 2) {
                    dsu.union(i, j);
                }
            }
        }

        return dsu.getComponents();
    }

}

class DSU {
    int[] root;
    int[] rank;
    int components;

    DSU (int n) {
        root = new int[n];
        rank = new int[n];
        components = n;
        for (int i = 0; i < n; i++) {
            root[i] = i;
            rank[i] = 1;
        }
    }

    boolean union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX == rootY)
            return false;

        components--;
        if (rank[rootX] > rank[rootY]) {
            root[rootY] = rootX;
        } else if (rank[rootY] > rank[rootX]) {
            root[rootX] = rootY;
        } else {
            rank[rootX]++;
            root[rootY] = rootX;
        }

        return true;
    }

    int getComponents() {
        return components;
    }
    
    int find(int x) {
        if (x == root[x])
            return x;
        return root[x] = find(root[x]);
    }
    
}