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

        int studied = 0, semesters = 0, marker = -1;
        queue.offer(marker);
        while (!queue.isEmpty()) {
            int u = queue.poll();

            if (u == marker) {
                semesters++;
                if (!queue.isEmpty()) queue.offer(marker);
                continue;
            }
            studied++;

            for (int v : adjList[u]) {
                if (--indegree[v] == 0) {
                    queue.offer(v);
                }
            }
        }

        return studied == n ? semesters : -1;
    }
}