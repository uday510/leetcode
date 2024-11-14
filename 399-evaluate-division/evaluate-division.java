class Solution {
    Map<String, List<String>> graph;
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {

        graph = new HashMap<>();

        buildGraph(equations, values);
        
        int n = queries.size();
        double[] res = new double[n];
        for (int i = 0; i < n; ++i) {
            List<String> q = queries.get(i);
            String u = q.get(0);
            String v = q.get(1);

            res[i] = dfs(u, v, new HashSet<>());
        }
        return res;
    }
    private double dfs(String src, String des, Set<String> vis) {
        if (!graph.containsKey(src) || !graph.containsKey(des) || vis.contains(src)) {
            return -1;
        }

        if (src.equals(des)) {
            return 1;
        }

        vis.add(src);
        var neis = graph.get(src);
        for (int i = 0; i < neis.size(); i += 2) {
            String nei = neis.get(i);

            double val = Double.parseDouble(neis.get(i + 1));
            double res = dfs(nei, des, vis);

            if (res != -1) {
                return val * res;
            }
        }
        return -1;
    }
    private void buildGraph(List<List<String>> eqs, double[] vls) {
        for (int i = 0; i < eqs.size(); ++i) {
            List<String> eq = eqs.get(i);
            String u = eq.get(0);
            String v = eq.get(1);
            double w = vls[i];

            graph.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
            graph.get(u).add(String.valueOf(w));

            graph.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
            graph.get(v).add(String.valueOf(1/w));
        }
    }
}