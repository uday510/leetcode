class Solution {
    Map<String, List<String>> graph;
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        graph = new HashMap<>();

        buildGraph(equations, values);

        int n = queries.size();
        var res = new double[n];
        
        for (int i = 0; i < n; ++i) {
            List<String> query = queries.get(i);
            String src = query.get(0);
            String dest = query.get(1);

            res[i] = dfs(src, dest, new HashSet<>());
        }
        return res;
    }

    private double dfs(String src, String dest, Set<String> vis) {
        if (!graph.containsKey(src) || !graph.containsKey(dest) || vis.contains(src)) {
            return -1;
        }

        if (src.equals(dest)) {
            return 1;
        }

        vis.add(src);
        List<String> neighbors = graph.get(src);
        for (int i = 0; i < neighbors.size(); i += 2) {
            String nei = neighbors.get(i);
            double val = Double.parseDouble(neighbors.get(i + 1));

            double res = dfs(nei, dest, vis);

            if (res != -1) {
                return val * res;
            }
        }
        return -1;
    }

    private void buildGraph(List<List<String>> equations, double[] values) {
        int n = equations.size();

        for(int i = 0; i < n; ++i) {
            List<String> equation = equations.get(i);
            
            String src = equation.get(0);
            String dest = equation.get(1);
            Double dist =  values[i];

            graph.computeIfAbsent(src, k -> new ArrayList<>()).add(dest);
            graph.get(src).add(String.valueOf(dist));

            graph.computeIfAbsent(dest, k -> new ArrayList<>()).add(src);
            graph.get(dest).add(String.valueOf(1/dist));
        }
    }
}