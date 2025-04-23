class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int n = numCourses;
        List<Integer>[] adjList = new ArrayList[n];

        for (int i = 0; i < n; ++i) adjList[i] = new ArrayList<>();
        int[] indegree = new int[n];

        for (int[] pre : prerequisites) {
            int u = pre[0];
            int v = pre[1];

            adjList[u].add(v);
            indegree[v]++;
        }

        Queue<Integer> queue = new ArrayDeque<>();
        int total = n;
        for (int i = 0; i < n; ++i) {
            if (indegree[i] == 0) {
                queue.offer(i);
                total--;
            }
        }

        

        while (!queue.isEmpty()) {
            int v = queue.poll();
            for (int nei : adjList[v]) {
                indegree[nei]--;
                if (indegree[nei] == 0) {
                    total--;
                    queue.offer(nei);
                }
            }
        }

        return total == 0;
    }
}
