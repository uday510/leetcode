class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        
        Map<String, Integer> owner = new HashMap<>();
        int n = accounts.size();
        DSU dsu = new DSU(n);

        for (int i = 0; i < n; i++) {
            List<String> ac = accounts.get(i);
            for (int j = 1; j < ac.size(); j++) {
                Integer id = owner.putIfAbsent(ac.get(j), i);
                if (id != null) {
                    dsu.union(id, i);
                }
            }
        }

        Map<Integer, List<String>> grps = new HashMap<>();
        for (Map.Entry<String, Integer> es : owner.entrySet()) {
            String email = es.getKey();
            Integer grp = dsu.find(es.getValue());

            grps.computeIfAbsent(grp, k -> new ArrayList<>()).add(email);
        }

        List<List<String>> res = new ArrayList<>();
        for (Map.Entry<Integer, List<String>> grp : grps.entrySet()) {
            Integer r = grp.getKey();
            List<String> emails = grp.getValue();

            Collections.sort(emails);
            emails.add(0, accounts.get(r).getFirst());
            res.add(emails);
        }

        return res;
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
            root[rx] = ry;
        }
    }

    int find(int x) {
        if (x == root[x])
            return x;
        return root[x] = find(root[x]);
    }

}

/**


["John","johnsmith@mail.com","john_newyork@mail.com"],
["John","johnsmith@mail.com","john00@mail.com"],
["Mary","mary@mail.com"],["John","johnnybravo@mail.com"]

"johnsmith@mail.com"        ->      0
"john_newyork@mail.com"     -> 

*/