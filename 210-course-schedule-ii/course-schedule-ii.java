class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer>[] adjList = new ArrayList[numCourses];
        int[] indegree = new int[numCourses];

        for (int i = 0; i < numCourses; i++) adjList[i] = new ArrayList<>();

        for (int[] p : prerequisites) {
            int u = p[1], v = p[0];

            adjList[u].add(v);
            indegree[v]++;
        }

        Queue<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) queue.offer(i);
        }

        System.out.println(queue);

        int[] res = new int[numCourses];
        int index = 0;

        while (!queue.isEmpty()) {
            int u = queue.poll();
            res[index++] = u;

            for (int v : adjList[u]) {
                if (--indegree[v] == 0) queue.offer(v);
            }
        }

        return index < res.length ? new int[] {} : res;
    }
}

