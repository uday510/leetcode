class Solution {

    private static final int UNREACHABLE = (int) 1e9;

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<int[]>[] adjList = new ArrayList[n];
        for (int i = 0; i < n; ++i) adjList[i] = new ArrayList<>();
        for (int[] flight : flights) {
            adjList[flight[0]].add(new int[] {flight[1], flight[2]});
        }

        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {src, 0, 0}); // node, cost, stops

        int[] minCostAtStops = new int[n];
        Arrays.fill(minCostAtStops, UNREACHABLE);
        minCostAtStops[src] = 0;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int node = curr[0], cost = curr[1], stops = curr[2];

            if (stops > k) continue;

            for (int[] neighbor : adjList[node]) {
                int nextNode = neighbor[0], price = neighbor[1];
                int newCost = cost + price;

                if (newCost < minCostAtStops[nextNode]) {
                    minCostAtStops[nextNode] = newCost;
                    queue.offer(new int[] {nextNode, newCost, stops + 1});
                }
            }
        }

        return minCostAtStops[dst] == UNREACHABLE ? -1 : minCostAtStops[dst];
    }
}