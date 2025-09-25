class Solution {
    
    Map<String, List<String>> adj;

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        UnionFind uf = new UnionFind(n);

        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < accounts.size(); i++) {
            var act = accounts.get(i);
            for (int j = 1; j < act.size(); j++) {
                String name = act.get(0);
                String email = act.get(j);

                if (!map.containsKey(email)) {
                    map.put(email, i);
                } else {
                    uf.union(i, map.get(email));
                }
            }
        }

        Map<Integer, List<String>> cmps = new HashMap<>();

        for (String email : map.keySet()) {
            int grp = map.get(email);
            int root = uf.find(grp);

            cmps.computeIfAbsent(root, _ -> new ArrayList<>()).add(email);
        }

        List<List<String>> res = new ArrayList<>();

        for (var e: cmps.entrySet()) {
            List<String> cur = e.getValue();
            Collections.sort(cur);
            cur.add(0, accounts.get(e.getKey()).get(0));
            res.add(cur);
        }

        return res;
    }
}

class UnionFind {
    int[] root, rank;

    UnionFind (int n) {
        root = new int[n];
        rank = new int[n];

        for (int i = 0; i < n; i++) {
            rank[i] = 1;
            root[i] = i;
        }
    }

    int find(int x) {
        if (x == root[x])
            return x;
        return root[x] = find(root[x]);
    }

    void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

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

/***


1 - [ johnsmith@mail.com, mary@mail.com, johnnybravo@mail.com ]

2 - [ john_newyork@mail.com, john00@mail.com ]



 */