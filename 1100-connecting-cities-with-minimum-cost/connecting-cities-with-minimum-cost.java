class Solution {
    public int minimumCost(int n, int[][] cons) {
        List<int[]>[] adjList = new ArrayList[n + 1];
        boolean[] inMST = new boolean[n + 1];

        for (int i = 1; i <= n; i++) adjList[i] = new ArrayList<>();

        for (int[] con : cons) {
            int u = con[0], v = con[1], w = con[2];

            adjList[u].add(new int[]{v, w});
            adjList[v].add(new int[]{u, w});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(edge -> edge[1]));
        pq.offer(new int[]{1, 0});
        int vis = 0, totalWeight = 0;

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int u = cur[0], w = cur[1];

            if (inMST[u]) continue;

            inMST[u] = true;
            vis++;
            totalWeight += w;

            for (int[] nxt : adjList[u]) {
                int v = nxt[0], w1 = nxt[1];

                if (!inMST[v]) {
                    pq.offer(new int[] {v, w1});
                }
            }
        }

        return vis == n ? totalWeight : -1;
    }
}