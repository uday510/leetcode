class Solution {

    private static final int UNREACHABLE = (int) 1e9;
    
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        if (flights.length == 0) return 0;
        
        List<int[]>[] adjList = new ArrayList[n];

        for (int idx = 0; idx < n; ++idx) adjList[idx] = new ArrayList<>();

        for (int[] flight : flights) {
            int from = flight[0], to = flight[1], dest = flight[2];
            adjList[from].add(new int[] {to, dest});
        }

        int[] dists = new int[n];
        Arrays.fill(dists, UNREACHABLE);

        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {src, 0});
        dists[src] = 0;
        int currStops = 0;
        
        while (currStops++ <= k && !queue.isEmpty()) {
            int size = queue.size();
            
            while (--size >= 0) {
                int[] curr = queue.poll();
                assert curr != null;
                int currStop = curr[0], currDist = curr[1];
                
                
                for (int[] next : adjList[currStop]) {
                    int nextStop = next[0], newNextStopDist = next[1] + currDist;
                    
                    if (newNextStopDist < dists[nextStop]) {
                        dists[nextStop] = newNextStopDist;
                        queue.offer(new int[] {nextStop, newNextStopDist});
                    }
                }
            }
        }

        System.out.println(Arrays.toString(dists));

        return dists[dst] == UNREACHABLE ? -1 : dists[dst];
    }
}