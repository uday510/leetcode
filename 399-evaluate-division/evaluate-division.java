class Solution {

    private Map<String, List<Edge>> adj;
    private int n;

    public double[] calcEquation(List<List<String>> E, double[] V, List<List<String>> Q) {
        n = E.size();
        adj = new HashMap<>();

        String u, v;
        Double w;

        for (int i = 0; i < n; i++) {
            List<String> e = E.get(i);
            u = e.get(0); v = e.get(1);
            w = V[i];

            adj.computeIfAbsent(u, _ -> new ArrayList<>()).add(new Edge(v, w));
            adj.computeIfAbsent(v, _ -> new ArrayList<>()).add(new Edge(u, 1.0 / w));
        }


        double[] res = new double[Q.size()];

        for (int i = 0; i < Q.size(); i++) {
            u = Q.get(i).get(0); v = Q.get(i).get(1);

            res[i] = bfs(u, v);
        }

        return res;
    }

    private double bfs(String src, String dest) {
        Set<String> vis = new HashSet<>();
        Queue<Edge> queue = new ArrayDeque<>();

        vis.add(src);
        queue.offer(new Edge(src, 1.0));

        Edge cur;
        String u;
        Double w;

        while (!queue.isEmpty()) {
            cur = queue.poll();
            u = cur.v;
            w = cur.d;
            
            if (!adj.containsKey(u)) return -1.0;

            if (u.equals(dest)) return w;

            for (Edge e : adj.get(u)) {
                Double w1 = w * e.d;

                if (!vis.contains(e.v)) {
                    vis.add(e.v);
                    queue.offer(new Edge(e.v, w1));
                }
                
            }

        }

        return -1.0;
    }
}

class Edge {
    String v;
    Double d;

    Edge (String v, Double d) {
        this.v = v;
        this.d = d;
    }

}
