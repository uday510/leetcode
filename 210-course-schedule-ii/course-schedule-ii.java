class Solution {
    public int[] findOrder(int n, int[][] edges) {
        List<Integer>[] adjList = new ArrayList[n];
        int[] indegree = new int[n];

        int[] res = new int[n];
        int idx = 0;
        int completed = 0;

        for (int i = 0; i < n; ++i) adjList[i] = new ArrayList<>();

        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];

            adjList[v].add(u);
            indegree[u]++;
        }

        Queue<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < n; ++i) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int v = queue.poll();
            res[idx++] = v;
            completed++;

            for (int nei : adjList[v]) {
                indegree[nei]--;
                if (indegree[nei] == 0) {
                    queue.offer(nei);
                }
            }
        }

        return completed == n ? res : new int[]{};
    }
}