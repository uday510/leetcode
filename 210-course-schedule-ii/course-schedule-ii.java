class Solution {
    public int[] findOrder(int n, int[][] pre) {
        List<Integer>[] adjList = new ArrayList[n];
        int[] indegree = new int[n];

        for (int i = 0; i < n; i++) adjList[i] = new ArrayList<>();

        for (int[] p : pre) {
            int u = p[0], v = p[1];
            adjList[v].add(u);
            indegree[u]++;
        }

        Queue<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) queue.offer(i);
        }

        int[] res = new int[n];
        int numFinished = 0, idx = 0;

        while (!queue.isEmpty()) {
            int u = queue.poll();
            numFinished++;
            res[idx++] = u;

            for (int v : adjList[u]) {
                if (--indegree[v] == 0) {
                    queue.offer(v);
                }
            }
        }

        return numFinished == n ? res : new int[] {};
    }
}