class Solution {

    int n;  
    Set<Integer> visited;
    int[][] edges;
    
    public int findCircleNum(int[][] edges) {
        n = edges.length;
        int numComponents = 0;
        this.edges = edges;
        visited = new HashSet<>();

        for (int i = 0; i < n; ++i) {
            if (!visited.contains(i)) {
                numComponents++;
                dfs(edges[i]);
            }
        }

        return numComponents;
    }

    private void dfs(int[] nodes) {
        for (int i = 0; i < nodes.length; ++i) {
            if (nodes[i] == 1 && !visited.contains(i)) {
                visited.add(i);
                dfs(edges[i]);
            }
        }
    }
}