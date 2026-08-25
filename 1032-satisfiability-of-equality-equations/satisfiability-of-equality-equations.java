class Solution {
    public boolean equationsPossible(String[] eqs) {
        DSU dsu = new DSU(26);

        for (String e : eqs) {

            if (e.charAt(1) == e.charAt(2)) {
                dsu.union(e.charAt(0) - 'a', e.charAt(3) - 'a');
            }
        }

        for (String e : eqs) {
            if (e.charAt(1) != e.charAt(2) && (
                dsu.find(e.charAt(0) - 'a') == dsu.find(e.charAt(3) - 'a'))
                ) {
                return false;
            }
        }

        return true;
    }
}

class DSU {
    int[] rank;
    int[] root;

    DSU (int n) {
        rank = new int[n];
        root = new int[n];

        for (int i = 0; i < n; i++) {
            rank[i] = 1;
            root[i] = i;
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
}