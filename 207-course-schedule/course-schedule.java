class Solution {
    public boolean canFinish(int n, int[][] edges) {
        

        List<Integer>[] adjList = new ArrayList[n];

        for (int i = 0; i < n; ++i) adjList[i] = new ArrayList<>();
        int[] indegree = new int[n];

        for (int[] e : edges) {
            int u = e[0], v = e[1];
            adjList[v].add(u);
            indegree[u]++;
        }

        Queue<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < n; ++i) if (indegree[i] == 0) queue.offer(i);

        int total = 0;
        while (!queue.isEmpty()) {
            Integer curr = queue.poll();
            total++;

            for (int next : adjList[curr]) {
                indegree[next]--;

                if (indegree[next] == 0) queue.offer(next);
            }
        }

        return total == n;
    }
}