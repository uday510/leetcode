class Solution {
    private static final int UNREACHABLE = (int) 1e9;

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<int[]>[] adjList = new ArrayList[n];

        for (int idx = 0; idx < n; ++idx) {
            adjList[idx] = new ArrayList<>();
        }

        for (int[] flight : flights) {
            int from = flight[0], to = flight[1], dest = flight[2];
            adjList[from].add(new int[] {to, dest});
        }

        int[] dists = new int[n];
        Arrays.fill(dists, UNREACHABLE);

        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {src, 0});
        int stops = 0;

       while (stops <= k) {
           int size = queue.size();

           for (int i = 0; i < size; ++i) {
            int[] curr = queue.poll();
            int node = curr[0], cost = curr[1];

                for (int[] neighbor : adjList[node]) {
                    int nextNode = neighbor[0], price = neighbor[1];
                    int newCost = cost + price;

                    if (newCost > dists[nextNode]) continue;

                     dists[nextNode] = newCost;
                    queue.offer(new int[] {nextNode, newCost});
                }
           }
           stops++;
       }

        return dists[dst] == UNREACHABLE ? -1 : dists[dst];
    }
}