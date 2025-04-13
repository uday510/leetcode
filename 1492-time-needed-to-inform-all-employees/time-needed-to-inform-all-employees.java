class Solution {
    List<Integer>[] adjList;
    int[] informTime;
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        adjList = new ArrayList[n];
        this.informTime = informTime;

        for (int i = 0; i < n; ++i) adjList[i] = new ArrayList<>();

        for (int i = 0; i < n; ++i)
            if (manager[i] != -1) adjList[manager[i]].add(i);

        return dfs(headID);
    }
    private int dfs(int node) {
        int time = 0;

        for (int nei : adjList[node]) {
            time = Math.max(time, dfs(nei));
        }

        return time + informTime[node];
    }
}