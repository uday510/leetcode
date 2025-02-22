class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> paths = new ArrayList<>();
        int n = graph.length;

        if (graph == null || graph.length == 0) {
            return paths;
        }

        Queue<List<Integer>> queue = new LinkedList<>();

        List<Integer> path = new ArrayList(Arrays.asList(0));

        queue.offer(path);

        while (!queue.isEmpty()) {
            path = queue.poll();

            if (path.getLast() == n - 1) {
                paths.add(new ArrayList<>(path));
            }

            for (int neighbor : graph[path.getLast()]) {
                List<Integer> newPath = new ArrayList<>(path);
                newPath.add(neighbor);
                queue.offer(new ArrayList<>(newPath));
            }
        }

        return paths;
    }
}