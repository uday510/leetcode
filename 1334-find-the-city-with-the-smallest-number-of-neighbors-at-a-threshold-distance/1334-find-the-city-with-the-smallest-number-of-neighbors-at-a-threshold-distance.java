import java.util.*;

class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        Map<Integer, List<int[]>> graph = new HashMap<>();
        int INF = Integer.MAX_VALUE;

        for (int[] edge : edges) {
            int src = edge[0];
            int dest = edge[1];
            int cost = edge[2];

            graph.computeIfAbsent(src, x -> new ArrayList<>()).add(new int[]{dest, cost});
            graph.computeIfAbsent(dest, x -> new ArrayList<>()).add(new int[]{src, cost});
        }

        int res = -1;
        int minReachableCities = n;

        for (int i = 0; i < n; i++) {
            int reachableCities = dijkstra(i, n, graph, distanceThreshold, INF);
            if (reachableCities <= minReachableCities) {
                minReachableCities = reachableCities;
                res = i;
            }
        }

        return res;
    }

    private int dijkstra(int start, int n, Map<Integer, List<int[]>> graph, int distanceThreshold, int INF) {
        int[] distFromSrc = new int[n];
        Arrays.fill(distFromSrc, INF);
        distFromSrc[start] = 0;

        PriorityQueue<Edge> minHeap = new PriorityQueue<>((a, b) -> a.cost - b.cost);
        minHeap.offer(new Edge(start, 0));

        while (!minHeap.isEmpty()) {
            Edge edge = minHeap.poll();
            int node = edge.dest;
            int cost = edge.cost;

            if (cost > distFromSrc[node]) {
                continue;
            }

            if (graph.get(node) == null) {
                continue;
            }

            for (int[] next : graph.getOrDefault(node, new ArrayList<>())) {
                int nextNode = next[0];
                int nextCost = next[1];

                if (distFromSrc[nextNode] > cost + nextCost) {
                    distFromSrc[nextNode] = cost + nextCost;
                    minHeap.offer(new Edge(nextNode, cost + nextCost));
                }
            }
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            if (i != start && distFromSrc[i] <= distanceThreshold) {
                count++;
            }
        }

        return count;
    }

    class Edge {
        int dest;
        int cost;

        public Edge(int dest, int cost) {
            this.dest = dest;
            this.cost = cost;
        }
    } 
}