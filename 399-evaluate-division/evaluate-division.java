class Solution {

    Map<String, List<Pair>> adjList;
    int n;

    public double[] calcEquation(List<List<String>> E, double[] V, List<List<String>> Q) {
        n = E.size();
        adjList = new HashMap<>();

        for (int i = 0; i < n; i++) {
            var e = E.get(i);

            String u = e.get(0), v = e.get(1);
            double d = V[i];

            adjList.computeIfAbsent(u, k -> new ArrayList<>()).add(new Pair(v, d));
            adjList.computeIfAbsent(v, k -> new ArrayList<>()).add(new Pair(u, 1.0 / d));
        }

        double[] D = new double[Q.size()];

        for (int i = 0; i < Q.size(); i++) {
            String u = Q.get(i).get(0), v = Q.get(i).get(1);

            D[i] = dfs(u, v, new HashSet<>());
        }

        return D;
    }

    private double dfs(String u, String v, Set<String> vis) {
        if (!adjList.containsKey(u) || !adjList.containsKey(v) || !vis.add(u)) return -1.0;

        if (u.equals(v)) return 1.0;

        for (Pair nei : adjList.get(u)) {
            double d = dfs(nei.v, v, vis);

            if (d != -1.0) return nei.d * d;
        }

        return -1.0;
    }
}

class Pair {
    String v;
    Double d;

    Pair(String v, Double d) {
        this.v = v;
        this.d = d;
    }
}