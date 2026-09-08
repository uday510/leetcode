class Solution {
    public double maxProbability(int n, int[][] edges, double[] prob, int st, int en) {
        
        List<Edge>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < edges.length; i++) {
            int[] e = edges[i];
            double d = prob[i];
            int u = e[0], v = e[1];

            adj[u].add(new Edge(v, d));
            adj[v].add(new Edge(u, d));
        }

        Queue<Edge> pq = new PriorityQueue<>((o1, o2) -> Double.compare(o2.d, o1.d));

        Double[] dists = new Double[n];
        Arrays.fill(dists, 0.0);
        dists[st] = 1.0;
        pq.offer(new Edge(st, 1.0));
        
        while (!pq.isEmpty()) {
            Edge e = pq.poll();
            Integer u = e.v;
            Double w = e.d;

            if (u == en) {
                return w;
            }

            for (Edge nxt : adj[u]) {
                Integer v = nxt.v;
                Double w1 = w * nxt.d;

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
    Double d;

    Edge (Integer v, Double d) {
        this.v = v;
        this.d = d;
    }
}