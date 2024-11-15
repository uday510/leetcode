class Solution {
    Map<Integer, List<Integer>> graph;
    Queue<Integer> queue;
    int[] indegree;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        graph = new HashMap<Integer, List<Integer>>();
        indegree = new int[numCourses];
        queue = new LinkedList<Integer>();
        int vis = 0;

        buildGraph(prerequisites);

        addNodes(numCourses);

        while (!queue.isEmpty()) {
            int node = queue.poll();
            ++vis;

            addNodesToQueue(node);
        }

        return canAllCoursesFinished();
    }
    private void buildGraph(int[][] prerequisites) {
         for (int[] pre : prerequisites) {
            graph.computeIfAbsent(pre[1], k -> new ArrayList<>()).add(pre[0]);
            ++indegree[pre[0]];
        }
    }
    private void addNodes(int numCourses) {
        for (int i = 0; i < numCourses; ++i) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }
    }
    private boolean canAllCoursesFinished() {
        for (int i = 0; i < indegree.length; ++i) {
            if (indegree[i] != 0) {
                return false;
            }
        }
        return true;
    }
    private void addNodesToQueue(int node) {
        for (int nei : graph.getOrDefault(node, new ArrayList<>())) {
            --indegree[nei];
            if (indegree[nei] == 0) {
                queue.offer(nei);
            }
        }
    }
}