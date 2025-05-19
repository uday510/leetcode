class Solution {

    public int networkDelayTime(int[][] times, int n, int k) {
        int INF = (int) 1e9;
        List<int[]>[] adjList = new ArrayList[n + 1];
        for (int i = 1; i <= n; ++i) adjList[i] = new ArrayList<>();

        for (int[] time : times) {
            int u = time[0], v = time[1], w = time[2];
            adjList[u].add(new int[] {v, w});
        }

        int[] delayTimeFromK = new int[n + 1];
        Arrays.fill(delayTimeFromK, INF);

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            return a[1] - b[1];
        });

        pq.offer(new int[] {k, 0});
        delayTimeFromK[k] = 0;

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int u = curr[0], w = curr[1];

            if (delayTimeFromK[u] < w) continue;

            for (int[] neighbor : adjList[u]) {
                int v = neighbor[0], neighborDelayTime = neighbor[1];
                int neighborDelayTimeFromU = neighborDelayTime + w;

                if (neighborDelayTimeFromU < delayTimeFromK[v]) {
                    delayTimeFromK[v] = neighborDelayTimeFromU;
                    pq.offer(new int[] {v, neighborDelayTimeFromU});
                }
            }
        }

        int minDelayTime = -INF;
        for (int idx = 1; idx <= n; ++idx) {
            int currDelayTime = delayTimeFromK[idx];
            if (currDelayTime == INF) return -1;
            minDelayTime = Math.max(minDelayTime, currDelayTime);
        }

        return minDelayTime;
    }
    
}