class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        if (src == dst) {
            return 0;
        }

        int[] previous = new int[n];
        int[] current = new int[n];

        for (int i = 0; i < n; ++i) {
            previous[i] = current[i] = Integer.MAX_VALUE;
        }
        previous[src] = 0;

        for (int i = 0; i <= k; ++i) {
            for (int[] flight : flights) {
                int from = flight[0];
                int to = flight[1];
                int cost = flight[2];

                if (previous[from] < Integer.MAX_VALUE) {
                    current[to] = Math.min(current[to], previous[from] + cost);
                }
            }
            previous = current.clone();
        }
        return current[dst] == Integer.MAX_VALUE ? -1 : current[dst];
    }
}