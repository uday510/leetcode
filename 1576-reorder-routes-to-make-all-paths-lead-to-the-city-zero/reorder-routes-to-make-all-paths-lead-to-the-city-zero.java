class Solution {
    List<int[]>[] adjList;
    boolean[] vis;
    int cnt;
    public int minReorder(int n, int[][] connections) {
        adjList = new ArrayList[n];
        vis = new boolean[n];
        cnt = 0;

        for (int i = 0; i < n; ++i) {
            adjList[i] = new ArrayList<>();
        }

        for (int[] connection : connections) {
            adjList[connection[0]].add(new int[]{connection[1], 1});
            adjList[connection[1]].add(new int[]{connection[0], 0});
        }
        
        dfs(0);
        return cnt;
    }
    private void dfs(int node) {
        if (vis[node]) return;
        
        vis[node] = true;
        for (int[] curr : adjList[node]) {
            if (vis[curr[0]]) continue;
            cnt += curr[1];
            dfs(curr[0]);
        }
    }
}