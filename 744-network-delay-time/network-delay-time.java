class Solution {
    private static final int UNREACHABLE = (int) 1e9; 
    public int networkDelayTime(int[][] times, int n, int k) {
        List<int[]>[] adjList = new ArrayList[n + 1];
        for (int i = 1; i <= n; ++i) adjList[i] = new ArrayList<>();

        for (int[] time : times) adjList[time[0]].add(new int[]{time[1], time[2]});

        int[] dists = new int[n + 1];
        Arrays.fill(dists, UNREACHABLE);

        Queue<int[]> queue = new PriorityQueue<>((edge1, edge2) -> edge1[1] - edge2[1]);
        queue.offer(new int[]{k, 0});
        dists[k] = 0;

        while (!queue.isEmpty()) {
            int[] currEdge = queue.poll();
            int currNode = currEdge[0], currDist = currEdge[1];

            if (dists[currNode] < currDist) continue;
            dists[currNode] = currDist;

            for (int[] neiNode : adjList[currNode]) {
                if (dists[neiNode[0]] != UNREACHABLE) continue;
                int[] newEdge = new int[]{neiNode[0], neiNode[1] + currDist};
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