class Solution {
    List<Integer>[] adjList;
    Set<Integer> seen;
    int n;
    public int countComponents(int n, int[][] edges) {
        initialize(n, edges);
        int numComponents = 0;

        for (int i = 0; i < n; ++i) {
            if (!seen.contains(i)) {
                numComponents++;
                dfs(i);
            }
        }
        return numComponents;
    }

    private void dfs(int node) {

        for (Integer vertex : adjList[node]) {
            if (seen.add(vertex)) {
                dfs(vertex);
            }
        }
    }

    private void initialize(int n, int[][] edges) {
        this.n = n;
        adjList = new ArrayList[n];
        seen = new HashSet<>();

        for (int i = 0; i < n; ++i) {
            adjList[i] = new ArrayList<Integer>();
        }

        for (int[] edge : edges) {
            adjList[edge[0]].add(edge[1]);
            adjList[edge[1]].add(edge[0]);
        }
    }
}