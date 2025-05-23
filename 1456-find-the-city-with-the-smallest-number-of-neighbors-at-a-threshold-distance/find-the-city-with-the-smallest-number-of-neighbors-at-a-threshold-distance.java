class Solution {
    
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        final List<int[]>[] adjList = new ArrayList[n];

        for (int i = 0; i < n; ++i) adjList[i] = new ArrayList<>();
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], w = edge[2];
            adjList[u].add(new int[] {v, w});
            adjList[v].add(new int[] {u, w});
        }

        int minVisits = (int) 1e9, ans = -1;

        for (int node = 0; node < n; ++node) {
            int currVisits = getCitiesVisits(node, n, adjList, distanceThreshold);
            if (currVisits <= minVisits) {
                ans = node;
                minVisits = currVisits;
            }
        }

        return ans;

    }

    private int getCitiesVisits(final int node, final int n, final List<int[]>[] adjList, final int distanceThreshold) {
        final int[] dists = new int[n];
        final int[] cities = new int[n];
        final int INF = (int) 1e9;

        Arrays.fill(dists, INF);

        final PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[1] != b[1]) return a[1] - b[1];
            return b[0] - a[0];
        });
        
        pq.offer(new int[]{node, 0, 1});
        dists[node] = 0;
        cities[node] = 1;
        
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int u = curr[0], w = curr[1], city = curr[2];
            
            if (dists[u] < w) continue;
            
            for (int[] next : adjList[u]) {
                int v = next[0], w1 = next[1];
                int w2 = w + w1;

                if (w2 > distanceThreshold) continue;
                                
                if (w2 < dists[v]) {
                    dists[v] = w2;
                    cities[v] = city + 1;
                    pq.offer(new int[] {v, w2, city + 1});
                }
            }
        }

       int cnt = -1;
       StringBuilder sb = new StringBuilder();
       for (int i = 0; i < n; ++i) {
            if (dists[i] <= distanceThreshold && node != i) {
                cnt += 1;
                sb.append("City").append(i).append(" ");
            }
       }

        System.out.println(node + " ->  " + sb.toString());
    
        return cnt;
    }
}