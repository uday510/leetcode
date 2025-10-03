class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        List<Integer>[] adjList = new ArrayList[numCourses];

        for (int i = 0; i < numCourses; i++) adjList[i] = new ArrayList<>();

        int[] indegree = new int[numCourses];

        for(int[] pre : prerequisites) {
            int u = pre[1], v = pre[0];

            adjList[u].add(v);
            indegree[v]++;
        }

        Queue<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) queue.offer(i);
        }

        int completedCourses = 0;

        while (!queue.isEmpty()) {
            int u = queue.poll();

            completedCourses++;

            for (int v : adjList[u]) {
                
                if (--indegree[v] == 0) {
                    queue.offer(v);
                }
            }
        }


        return completedCourses == numCourses;
    }
}