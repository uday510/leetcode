class Solution {
    List<Integer>[] adjList;
    boolean[] visited;
    int numComponents;
    public int countCompleteComponents(int n, int[][] edges) {
        if (n == 0) return 0;
        initialize(n, edges);

        for (int idx = 0; idx < n; ++idx) {
            if (!visited[idx]) {
                Set<Integer> list = dfs(idx, new HashSet<>());

                boolean isComplete = true;
                for (var node : list) {
                    if (adjList[node].size() != list.size() - 1) {
                        isComplete = false;
                        break;
                    }
                }

                numComponents += isComplete ? 1 : 0;
            }
        }

        return numComponents;
    }

    private Set<Integer> dfs(int node, Set<Integer> list) {
        list.add(node);
        visited[node] = true;

        for (Integer neighbor : adjList[node]) {
            if (!visited[neighbor]) {
                list.add(neighbor);
                dfs(neighbor, list);
            }
        }
        return list;
    }

    private void initialize(int n, int[][] edges) {
        adjList = new ArrayList[n];
        visited = new boolean[n];
        numComponents = 0;

        for (int idx = 0; idx < n; ++idx) {
            adjList[idx] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            adjList[edge[0]].add(edge[1]);
            adjList[edge[1]].add(edge[0]);
        }
    }
}