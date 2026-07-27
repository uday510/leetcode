class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        
        int n = accounts.size();
        DSU dsu = new DSU(n);
        Map<String, Integer> owner = new HashMap<>();

        for (int i = 0; i < n; i++) {
            List<String> acc = accounts.get(i);
            for (int j = 1; j < acc.size(); j++) {
                Integer id = owner.putIfAbsent(acc.get(j), i);
                if (id != null) dsu.union(id, i);
            }
        }

        Map<Integer, List<String>> groups = new HashMap<>();
        for (Map.Entry<String, Integer> es : owner.entrySet()) {
            String email = es.getKey();
            Integer group = dsu.find(es.getValue());

            groups.computeIfAbsent(group, k -> new ArrayList<>()).add(email);
        }

        List<List<String>> res = new ArrayList<>();

        for (Map.Entry<Integer, List<String>> group : groups.entrySet()) {
            Integer root = group.getKey();
            List<String> emails = group.getValue();

            Collections.sort(emails);
            emails.add(0, accounts.get(root).getFirst());
            res.add(emails);
        }

        return res;
    }
}


class DSU {
    private int[] rank;
    private int[] root;

    public DSU (int n) {
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

    boolean isConnected(int x, int y) {
        return find(x) == find(y);
    }
}

/**


johnsmith@mail.com -> 0
john_newyork@mail.com -> 0
john00@mail.com -> 1
mary@mail.com -> 2
johnnybravo@mail.com -> 3

0 -> [johnsmith@mail.com, john_newyork@mail.com]
1 -> [john00@mail.com]
2 -> [mary@mail.com]
3 -> [johnnybravo@mail.com]




*/