class Solution {
    public double maxProbability(int n, int[][] edges, double[] probs, int st, int en) {
        
        List<Edge>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0], v = edges[i][1];
            double w = probs[i];
            adj[u].add(new Edge(v, w));
            adj[v].add(new Edge(u, w));
        }

        Queue<Edge> pq = new PriorityQueue<>((o1, o2) -> Double.compare(o2.w, o1.w));
        Double[] dists = new Double[n];

        Arrays.fill(dists, 0.0);
        dists[st] = 1.0;
        pq.offer(new Edge(st, 1.0));

        while (!pq.isEmpty()) {
            Edge e = pq.poll();
            Integer u = e.v;
            Double w = e.w;

            if (u == en) {
                return w;
            }

            if (dists[u] > w) {
                continue;
            }

            for (Edge nxt : adj[u]) {
                Integer v = nxt.v;
                Double w1 = w * nxt.w;

                if (w1 > dists[v]) {
                    dists[v] = w1;
                    pq.offer(new Edge(v, w1));
                }

            }
        }

        return 0;
    }
}
class Edge {
    Integer v;
    Double w;

    Edge (Integer v, Double w) {
        this.v = v;
        this.w = w;
    }
}