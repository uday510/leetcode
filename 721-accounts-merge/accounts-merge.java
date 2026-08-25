class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        DSU dsu = new DSU(n);
        Map<String, Integer> owner = new HashMap<>();

        for (int i = 0; i < n; i++) {
            var ac = accounts.get(i);
            for (int j = 1; j < ac.size(); j++) {
                String email = ac.get(j);
                Integer id = owner.putIfAbsent(email, i);
                if (id != null) {
                    dsu.union(id, i);
                }
            }
        }

        Map<Integer, List<String>> groups = new HashMap<>();

        for (Map.Entry<String, Integer> es : owner.entrySet()) {
            String email = es.getKey();
            Integer id = es.getValue();

            int root = dsu.find(id);
            groups.computeIfAbsent(root, k -> new ArrayList<>()).add(email);
        }

        List<List<String>> res = new ArrayList<>();
        for (Map.Entry<Integer, List<String>> es : groups.entrySet()) {
            Integer id = es.getKey();
            List<String> emails = es.getValue();

            Collections.sort(emails);
            emails.add(0, accounts.get(id).getFirst());
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

{
    johnnybravo@mail.com=3, 
    johnsmith@mail.com=0, 
    john00@mail.com=1, 
    john_newyork@mail.com=0, 
    mary@mail.com=2
}

 */