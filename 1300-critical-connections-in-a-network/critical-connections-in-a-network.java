class Solution {

    private Map<Integer, List<Integer>> adj;
    private Map<Integer, Integer> rank;
    private Map<Pair, Boolean> conn;

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> conns) {

        initialize(n, conns);
        dfs(0, 0);

        List<List<Integer>> res = new ArrayList<>();
        for (Pair cc : conn.keySet()) {
            res.add(new ArrayList<Integer>(Arrays.asList(cc.u, cc.v)));
        }

        return res;
    }
    
    private int dfs(int u, int r) {
        if (this.rank.get(u) != null) {
            return this.rank.get(u);
        }
        
        this.rank.put(u, r);
        
        int mn = r + 1;
        
        for (int v : adj.get(u)) {
            
            Integer nr = rank.get(v);
            if (nr != null && nr == r - 1) {
                continue;
            }
            
            int nxt = dfs(v, r + 1);
            
            if (nxt <= r) {
                int sU = Math.min(u, v), sv = Math.max(u, v);
                conn.remove(new Pair(sU, sv));
            }
            
            mn = Math.min(mn, nxt);
        }
        
        return mn;
    }
    
    private void initialize(int n, List<List<Integer>> list) {

        this.adj = new HashMap<>();
        this.rank = new HashMap<>();
        this.conn = new HashMap<>();

        for (int i = 0; i < n; i++) {
            this.adj.put(i, new ArrayList<>());
            this.rank.put(i, null);
        }

        for (List<Integer> edge : list) {

            int u = edge.get(0), v = edge.get(1);
            this.adj.get(u).add(v);
            this.adj.get(v).add(u);

            int sortedU = Math.min(u, v), sortedV = Math.max(u, v);
            conn.put(new Pair(sortedU, sortedV), true);
        }

    }

    private static class Pair {
    int u, v;

    Pair(int k, int v) {
        this.u = k;
        this.v = v;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Pair)) return false;
        Pair p = (Pair) o;
        return u == p.u && v == p.v;
    }

    @Override
    public int hashCode() {
        return 31 * u + v;
    }
    }

}
