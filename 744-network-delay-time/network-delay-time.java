class Solution {
    private static final int UNREACHABLE = (int) 1e9; 
    public int networkDelayTime(int[][] times, int n, int k) {
        List<Edge>[] adjList = new ArrayList[n + 1];
        for (int i = 1; i <= n; ++i) adjList[i] = new ArrayList<>();

        for (int[] time : times) adjList[time[0]].add(new Edge(time[1], time[2]));

        int[] dists = new int[n + 1];
        Arrays.fill(dists, UNREACHABLE);

        Queue<Edge> queue = new PriorityQueue<>((edge1, edge2) -> edge1.dist - edge2.dist);
        queue.offer(new Edge(k, 0));
        dists[k] = 0;

        while (!queue.isEmpty()) {
            Edge currEdge = queue.poll();
            int currNode = currEdge.to, currDist = currEdge.dist;

            if (dists[currNode] < currDist) continue;
            dists[currNode] = currDist;

            for (Edge neiNode : adjList[currNode]) {
                if (dists[neiNode.to] != UNREACHABLE) continue;
                Edge newEdge = new Edge(neiNode.to, neiNode.dist + currDist);
                queue.offer(newEdge);
            }
        }

        int max = -1;
        for (int i = 1; i <= n; ++i) {
            if (dists[i] == UNREACHABLE) return -1;
            max = Math.max(dists[i], max);
        }

        return max;
    }

    class Edge {
        int to, dist;
        Edge(int to, int dist) {
            this.to = to;
            this.dist = dist;
        }
    }
}