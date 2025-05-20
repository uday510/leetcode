class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        
        List<int[]>[] adjList = new ArrayList[n + 1];
        for (int i = 1; i <= n; ++i) adjList[i] = new ArrayList<>();
        for (int[] time : times) adjList[time[0]].add(new int[] {time[1], time[2]});

        int INF = (int) 1e9;
        int[] dists = new int[n + 1];
        Arrays.fill(dists, INF);

        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {k, 0});
        dists[k] = 0;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int node = curr[0], w = curr[1];

            if (dists[node] < w) continue;

            for (int[] next : adjList[node]) {
                int nei = next[0], neiW = next[1];

                if (neiW + w < dists[nei]) {
                    dists[nei] = neiW + w;
                    queue.offer(new int[] {nei, neiW + w});
                }
            }
        }

        int maxDelay = -INF;
        for (int idx = 1; idx <= n; ++idx) {
            if (dists[idx] == INF) return -1;
            maxDelay = Math.max(maxDelay, dists[idx]);
        }
        return maxDelay;
    }
}