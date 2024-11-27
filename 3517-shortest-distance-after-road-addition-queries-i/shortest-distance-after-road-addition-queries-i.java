class Solution {
    Map<Integer, List<Integer>> graph;
    int SOURCE;
    int DESTINATION;
    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        graph = new HashMap<>();
        SOURCE = 0;
        DESTINATION = n - 1;

        for (int i = 0; i <= n; ++i) {
            graph.put(i, new ArrayList<>());

            graph.get(i).add(i + 1);
        }

        int[] result = new int[queries.length];
        int index = 0;

        for (int[] query : queries) {
            int src = query[0];
            int dest = query[1];

            graph.get(src).add(dest);

            System.out.println(src + " : " + graph.get(src));

            result[index++] = getShortestDistance();
        }

        return result;
    }
    private int getShortestDistance() {

        Queue<int[]> queue = new LinkedList<>();
        int currentDistance = 0;
        Set<Integer> seen = new HashSet<>();

        queue.offer(new int[]{SOURCE, 0});
        seen.add(SOURCE);

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int node = curr[0];
            int dist = curr[1];

            if (node == DESTINATION) {
                return dist;
            }

            currentDistance += 1;

            for (Integer neighbor : graph.getOrDefault(node, new ArrayList<>())) {
                if (seen.contains(neighbor)) {
                    continue;
                }

                seen.add(neighbor);
                queue.offer(new int[]{neighbor, dist + 1});

            }        
        }

        return -1;
    }
}