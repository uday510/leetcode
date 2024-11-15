import java.util.*;

public class Solution {
    private Map<Integer, List<Integer>> graph;
    private Queue<Integer> queue;
    private int[] indegree;
    private int visited;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        initialize(numCourses);
        buildGraph(prerequisites);
        addNodesWithNoPrerequisites();

        while (!queue.isEmpty()) {
            int node = queue.poll();
            removeNodeFromGraph(node);
        }

        return visited == numCourses;
    }

    private void initialize(int numCourses) {
        graph = new HashMap<>();
        indegree = new int[numCourses];
        queue = new LinkedList<>();
        visited = 0;
    }

    private void buildGraph(int[][] prerequisites) {
        for (int[] prerequisite : prerequisites) {
            graph.computeIfAbsent(prerequisite[1], k -> new ArrayList<>()).add(prerequisite[0]);
            indegree[prerequisite[0]]++;
        }
    }

    private void addNodesWithNoPrerequisites() {
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }
    }

    private void removeNodeFromGraph(int node) {
        visited++;
        for (int neighbor : graph.getOrDefault(node, Collections.emptyList())) {
            indegree[neighbor]--;
            if (indegree[neighbor] == 0) {
                queue.offer(neighbor);
            }
        }
    }
}