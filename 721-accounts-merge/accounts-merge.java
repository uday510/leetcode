class Solution {

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, Integer> map = new HashMap<>();
        int n = accounts.size();
        UnionFind uf = new UnionFind(n);

        for (int i = 0; i < n; i++) {
            List<String> ac = accounts.get(i);

            for (int j = 1; j < ac.size(); j++) {
                String a = ac.get(j);

                map.putIfAbsent(a, i);
                uf.union(map.get(a), i);
            }
        }

        Map<Integer, List<String>> grps = new HashMap<>();

        for (Map.Entry<String, Integer> es : map.entrySet()) {
            String email = es.getKey();
            int grp = es.getValue();
            int root = uf.find(grp);
            
            grps.computeIfAbsent(root, _ -> new ArrayList<>()).add(email);
        }

        List<List<String>> res = new ArrayList<>();
        
        for (Map.Entry<Integer, List<String>> es : grps.entrySet()) {
            int root = es.getKey();
            List<String> emails = es.getValue();
            
            Collections.sort(emails);
            emails.add(0, accounts.get(root).get(0));
            
            res.add(emails);
        }

        return res;
    }

}

class UnionFind {
    int[] root, rank;

    UnionFind(int n) {
        this.root = new int[n];
        this.rank = new int[n];

        for (int idx = 0; idx < n; idx++) {
            root[idx] = idx;
            rank[idx] = 1;
        }
    }

    int find(int x) {
        if (x == root[x]) return x;

        return root[x] = find(root[x]);
    }

    void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX == rootY) return;

        if (rank[rootX] > rank[rootY]) {
            root[rootY] = rootX;
        } else if (rank[rootY] > root[rootX]) {
            root[rootX] = rootY;
        } else {
            root[rootY] = rootX;
            rank[rootX] += 1;
        }
    }

    boolean connected(int x, int y) {
        return find(x) == find(y);
    }
}