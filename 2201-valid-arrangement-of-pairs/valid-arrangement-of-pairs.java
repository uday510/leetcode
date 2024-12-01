class Solution {
    Map<Integer, Deque<Integer>> graph;
    Map<Integer, Integer> indegree;
    Map<Integer, Integer> outdegree;
    List<Integer> arrangement;
    int[][] result;

    public int[][] validArrangement(int[][] pairs) {
        intialize();
        buildGraph(pairs);

        int startingNode = getStartNode(pairs);

        dfs(startingNode);

        formResult();

        return result;
    }
    private void intialize() {
        graph = new HashMap<>();
        indegree = new HashMap<>();
        outdegree = new HashMap<>();
        arrangement = new ArrayList<>();
    }
    private void buildGraph(int[][] pairs) {
        for (int[] pair : pairs) {
            int start = pair[0];
            int end = pair[1];

            graph.computeIfAbsent(start, k -> new ArrayDeque<>()).add(end);

            indegree.put(end, indegree.getOrDefault(end, 0) + 1);
            outdegree.put(start, outdegree.getOrDefault(start, 0) + 1);
        }
    }
    private int getStartNode(int[][] pairs) {
        for (int node : outdegree.keySet()) {
            if (outdegree.get(node) == indegree.getOrDefault(node, 0) + 1) {
                return node;
            }
        }

        return pairs[0][0];
    }

    private void dfs(int node) {
        Deque<Integer> neighbors = graph.get(node);

        while (neighbors != null && !neighbors.isEmpty()) {
            int nextNode = neighbors.poll();
            dfs(nextNode);
        }

        arrangement.add(node);
    }

    private void formResult() {
        Collections.reverse(arrangement);
        result = new int[arrangement.size() - 1][2];

        for (int idx = 1; idx < arrangement.size(); ++idx) {
            result[idx - 1] = new int[] {arrangement.get(idx - 1), arrangement.get(idx)};
        }
    }
}