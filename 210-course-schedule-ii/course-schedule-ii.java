class Solution {
   @SuppressWarnings("unchecked")
    // O(V+E) time complexity | O(V+E) space complexity
    public int[] findOrder(int numCourses, int[][] prerequisites) {
       ArrayDeque<Integer> queue = new ArrayDeque<>();
       int[] inDegree = new int[numCourses];
       List<Integer>[] adjList = new ArrayList[numCourses];
       int[] order = new int[numCourses];
       int index = 0;
       int finishedCourses = 0;

       for (int idx = 0; idx < numCourses; idx++) {
           adjList[idx] = new ArrayList<>();
       }

       for (int[] prerequisite : prerequisites) {
           adjList[prerequisite[1]].add(prerequisite[0]);
           inDegree[prerequisite[0]]++;
       }

       for (int idx = 0; idx < numCourses; ++idx) {
           if (inDegree[idx] == 0) {
               queue.offerLast(idx);
           }
       }

       while (!queue.isEmpty()) {
           int course = queue.pollFirst();
           order[index++] = course;
           finishedCourses++;

           for (int neighborCourse : adjList[course]) {
                if (--inDegree[neighborCourse] == 0) {
                     queue.add(neighborCourse);
                }
           }
       }

       return finishedCourses == numCourses ? order : new int[]{};
    }
}