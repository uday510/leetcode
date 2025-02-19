class Solution {
    Map<String, List<String[]>> graph;
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        buildGraph(equations, values, queries);
        double[] result = new double[queries.size()];

        for (int idx = 0; idx < queries.size(); ++idx) {
            List<String> query = queries.get(idx);
            String src = query.get(0);
            String dest = query.get(1);

            double distance = dfs(src, dest, new HashSet<String>());
            result[idx] = distance;
        }

        return result;
    }

    private double dfs(String src, String dest, Set<String> visited) {
        if (!graph.containsKey(src) || !graph.containsKey(dest)) {
            return -1.0;
        }

        if (src.equals(dest)) {
            return 1.0;
        }

        for (String[] neighbor : graph.get(src)) {
            String next = neighbor[0];
            double dist = Double.parseDouble(neighbor[1]);
            if (!visited.add(next)) {
                continue;
            }

            double value = dfs(next, dest, visited);

            if (value != -1.0) {
                return dist * value;
            }
        }

        return -1.0;
    }

    private void buildGraph(List<List<String>> equations, double[] values, List<List<String>> queries) {
        graph = new HashMap<>();

        for (int idx = 0; idx < equations.size(); ++idx) {
            List<String> equation = equations.get(idx);
            String src = equation.get(0);
            String dest = equation.get(1);
            double dist = values[idx];

            graph.computeIfAbsent(src, k -> new ArrayList<>()).add(new String[]{dest, String.valueOf(dist)});
            graph.computeIfAbsent(dest, k -> new ArrayList<>()).add(new String[]{src, String.valueOf(1.0/dist)});
        }
    }
}