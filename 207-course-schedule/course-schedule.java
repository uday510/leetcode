class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] adjList = new ArrayList[numCourses];
        Queue<Integer> queue = new ArrayDeque<>();
        int[] indegree = new int[numCourses];
        for (int i = 0; i < numCourses; ++i) {
            adjList[i] = new ArrayList<>();
        }

        for (int[] prerequisite : prerequisites) {
            adjList[prerequisite[1]].add(prerequisite[0]);
            ++indegree[prerequisite[0]];
        }

        for (int i = 0; i < numCourses; ++i) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        int visited = numCourses;

        while (!queue.isEmpty()) {
            int vertex = queue.poll();
            System.out.println(vertex);
            --visited;
            for (int neighbor : adjList[vertex]) {
                --indegree[neighbor];
                if (indegree[neighbor] == 0) 
                    queue.offer(neighbor);
            }
        }
        return visited == 0;
    }
}