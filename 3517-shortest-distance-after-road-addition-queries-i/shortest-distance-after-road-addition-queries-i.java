import java.util.*;

public class Solution {
    private static final int SOURCE = 0;
    private Map<Integer, List<Integer>> graph;

    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        initializeGraph(n);
        int[] result = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            addEdge(queries[i][0], queries[i][1]);
            result[i] = getShortestDistance(n);
        }

        return result;
    }

    private void initializeGraph(int n) {
        graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
            if (i < n - 1) {
                graph.get(i).add(i + 1);
            }
        }
    }

    private void addEdge(int source, int destination) {
        graph.get(source).add(destination);
    }

    private int getShortestDistance(int n) {
        Queue<int[]> queue = new LinkedList<>();
        Set<Integer> seen = new HashSet<>();
        queue.offer(new int[]{SOURCE, 0});
        seen.add(SOURCE);

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int node = current[0];
            int distance = current[1];

            if (node == n - 1) {
                return distance;
            }

            for (Integer neighbor : graph.getOrDefault(node, new ArrayList<>())) {
                if (seen.contains(neighbor)) {
                    continue;
                }

                seen.add(neighbor);
                queue.offer(new int[]{neighbor, distance + 1});
            }
        }

        return -1;
    }
}