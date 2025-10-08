class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] adjList = new ArrayList[numCourses];
        int[] indegree = new int[numCourses];

        for (int i = 0; i < numCourses; i++) adjList[i] = new ArrayList<>();

        for (int[] p : prerequisites) {
            int u = p[0], v = p[1];
            
            adjList[v].add(u);
            indegree[u]++;
        }
        
        Queue<Integer> queue = new ArrayDeque<>();
        int finished = 0;
        
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) queue.offer(i);
        }

        while(!queue.isEmpty()) {
            int u = queue.poll();
            finished++;
            
            for (int v : adjList[u]) {
                if (--indegree[v] == 0) {
                    queue.offer(v);
                }
            }
        }

        return finished == numCourses;
    }
}