class Solution {
    Map<String, List<String>> graph;
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        graph = new HashMap<>();

        buildGraph(equations, values);

        double[] res = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            List<String> query = queries.get(i);
            String a = query.get(0);
            String b = query.get(1);
            res[i] = dfs(a, b, new HashSet<>());
        }
        return res;
    }
    private double dfs(String a, String b, Set<String> visited) {
        if (!graph.containsKey(a) || !graph.containsKey(b)) {
            return -1;
        }
        if (a.equals(b)) {
            return 1;
        }
        visited.add(a);
        List<String> neighbors = graph.get(a);
        for (int i = 0; i < neighbors.size(); i += 2) {
            String neighbor = neighbors.get(i);
            if (visited.contains(neighbor)) {
                continue;
            }
            double val = Double.parseDouble(neighbors.get(i + 1));
            double res = dfs(neighbor, b, visited);
            if (res != -1) {
                return val * res;
            }
        }
        return -1;
    }
     private void buildGraph(List<List<String>> eqs, double[] vs) {
        for (int i = 0; i < eqs.size(); i++) {
            List<String> eq = eqs.get(i);
            String a = eq.get(0);
            String b = eq.get(1);
            double v = vs[i];

            if (!graph.containsKey(a)) {
                graph.put(a, new ArrayList<>());
            }
            graph.get(a).add(b);
            graph.get(a).add(String.valueOf(v));

            if (!graph.containsKey(b)) {
                graph.put(b, new ArrayList<>());
            }
            graph.get(b).add(a);
            graph.get(b).add(String.valueOf(1/v));
        }
    }
}