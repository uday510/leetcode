class Solution {
    public double maxProbability(int n, int[][] E, double[] probs, int st, int en) {
        List<Edge>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();

        for (int i = 0; i < E.length; i++) {
            int u = E[i][0], v = E[i][1];
            double w = probs[i];
            adj[u].add(new Edge(v, w));
            adj[v].add(new Edge(u, w));
        }

        double[] dists = new double[n];
        Arrays.fill(dists, -1.0);
        
        Queue<Edge> pq = new PriorityQueue<>((o1, o2) -> Double.compare(o2.w, o1.w));

        dists[st] = 1.0;
        pq.offer(new Edge(st, 1.0));
        
        Edge cur;
        int u;
        double p;
        while (!pq.isEmpty()) {
            cur = pq.poll();
            u = cur.v;
            double w = cur.w;

            if (u == en) return w;
            if (w < dists[u]) continue;

            for (Edge e : adj[u]) {
                double newDist = w * e.w;

                if (newDist > dists[e.v]) {
                    dists[e.v] = newDist;
                    pq.offer(new Edge(e.v, newDist));
                }
            }
        }

        return 0.0;
    }
}

class Edge {
    int v;
    double w;
    Edge (int v, double w) {
        this.v = v;
        this.w = w;
    }
}