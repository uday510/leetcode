class Solution {

    int n;  
    List<Integer>[] adjList;
    Set<Integer> visited;
    
    public int findCircleNum(int[][] edges) {
        n = edges.length;
        adjList = new ArrayList[n];
        visited = new HashSet<>();
        int numComponents = 0;
        
        for (int i = 0; i < n; ++i) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < edges[i].length; ++j) {
                if (edges[i][j] == 1) {
                    adjList[i].add(j);
                }
            }
        }

        for (int v = 0; v < n; ++v) {
            if (!visited.contains(v)) {
                numComponents++;
                System.out.println(v);
                dfs(v);
            }
        }

        return numComponents;
    }

    private void dfs(Integer vertex) {
        
        for (Integer node : adjList[vertex]) {
            if (visited.add(node)) {
                dfs(node);
            }
        }
    }
}