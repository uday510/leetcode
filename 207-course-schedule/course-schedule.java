class Solution {
    public boolean canFinish(int n, int[][] edges) {
        List<Integer>[] adjList = new ArrayList[n];
        int[] indegree = new int[n];

        for (int i = 0; i < n; i++) adjList[i] = new ArrayList<>();

        for (int[] e : edges) {
            int u = e[0], v = e[1];

            adjList[v].add(u);
            indegree[u]++;
        }

        Queue<Integer> queue = new ArrayDeque<>();
        int numFinished = 0;

        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) queue.offer(i);
        }

        while (!queue.isEmpty()) {
            int u = queue.poll();
            numFinished++;

            for (int v : adjList[u]) {
                if (--indegree[v] == 0) {
                    queue.offer(v);
                }
            }
        }

        return numFinished == n;
    }
}