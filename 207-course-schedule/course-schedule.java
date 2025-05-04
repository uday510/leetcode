class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] adjList = new ArrayList[numCourses];
        int[] indegree = new int[numCourses];

        for (int i = 0; i < numCourses; ++i) {
            adjList[i] = new ArrayList<>();
        }

        for (int[] prerequisite : prerequisites) {
            int u = prerequisite[0], v = prerequisite[1];
            adjList[u].add(v);
            ++indegree[v];
        }

        Queue<Integer> queue = new ArrayDeque<>();
        for (int course = 0; course < indegree.length; ++course) {
            int degree = indegree[course];
            if (degree == 0) queue.offer(course);
        }

        if (queue.isEmpty()) return false;

        int coursesVisited = 0;
        while (!queue.isEmpty()) {
            Integer currCourse = queue.poll();
            ++coursesVisited;

            for (int neighbor : adjList[currCourse]) {
                if (--indegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }
        return coursesVisited == numCourses;
    }
}