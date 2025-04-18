class Solution {
    int[] time;
    List<Integer>[] adjList;
    boolean[] visited;
    int n;
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        this.n = n;
        this.time = informTime;
        adjList = new ArrayList[n];
        visited = new boolean[n];

        for (int i = 0; i < n; ++i) adjList[i] = new ArrayList<>();

        for (int i = 0; i < n; ++i) {
            if (manager[i] != -1) {
                adjList[manager[i]].add(i);
            }
        }

        return dfs(headID);
    }
    private int dfs(int node) {
        int curr = 0;

        for (Integer next : adjList[node]) {
            if (!visited[next]) {
                visited[next] = true;
                curr = Math.max(curr, dfs(next));
            }
        } 

        return curr + time[node];
    }
}