class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) return new ArrayList<>(List.of(0));

        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n; ++i) graph.add(new ArrayList<>());

        for (int[] e : edges) {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }

        List<Integer> leafNodes = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            if (graph.get(i).size() == 1) leafNodes.add(i);
        }

        while (n > 2) {
            n -= leafNodes.size();

            List<Integer> newLeafNodes = new ArrayList<>();

            for (int i : leafNodes) {
                int neighbor = graph.get(i).get(0);
                graph.get(neighbor).remove(Integer.valueOf(i));

                if (graph.get(neighbor).size() == 1) {
                    newLeafNodes.add(neighbor);
                }
            }
            leafNodes = newLeafNodes;
        }

        return leafNodes;
    }
}