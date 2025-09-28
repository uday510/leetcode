class Solution {
    public int minimumSemesters(int n, int[][] relations) {
        List<Integer>[] adjList = new ArrayList[n + 1];
        int[] indegree = new int[n + 1];

        for (int i = 1; i <= n; i++) adjList[i] = new ArrayList<>();

        for (int[] r : relations) {
            int u = r[0], v = r[1];
            adjList[u].add(v);
            indegree[v]++;
        }

        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            if (indegree[i] == 0) queue.offer(i);
        }

        int semesters = 0, studied = 0;
        while (!queue.isEmpty()) {
            semesters++;

            Queue<Integer> newQueue = new ArrayDeque<>();
            for (int u : queue) {
                studied++;
                for (int v : adjList[u]) { 
                    indegree[v]--;
                    if (indegree[v] == 0) {
                        newQueue.offer(v);
                    }
                }
            }

            queue = newQueue;
        }

        return studied == n ? semesters : -1;
    }
}

/**

1 -> 3
2 -> 3



 */