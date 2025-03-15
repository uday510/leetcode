class Solution {
    private List<Integer>[] adjList;
    private Queue<Integer> queue;
    private int[] indegree;
    int visited = 0;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // O(V+E) time complexity | O(V+E) space complexity

        initialize(numCourses);
        buildGraph(prerequisites);
        addNodesWithNoPreRequisites();

        while (!queue.isEmpty()) {
            int node = queue.poll();
            removeNodeFromGraph(node);
        }

        return visited == numCourses;
    }
    private void removeNodeFromGraph(int node) {
        visited++;
        for (int neighbour : adjList[node]) {
           indegree[neighbour]--;
           if (indegree[neighbour] == 0) {
               queue.offer(neighbour);
           }
        }
    }
    private void addNodesWithNoPreRequisites() {
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }
    }
    private void buildGraph(int[][] prerequisites) {
        for (int[] prerequisite : prerequisites) {
            adjList[prerequisite[1]].add(prerequisite[0]);
            indegree[prerequisite[0]]++;
        }
    }
    private void initialize(int numCourses) {
        queue = new LinkedList<>();
        indegree = new int[numCourses];
        adjList = new ArrayList[numCourses];

        for (int i = 0; i < numCourses; ++i) {
            adjList[i] = new ArrayList<>();
        }
    }
}
