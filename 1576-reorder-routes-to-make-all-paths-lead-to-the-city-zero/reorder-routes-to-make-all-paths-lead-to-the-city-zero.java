class Solution {

    List<int[]>[] adjList;
    boolean[] vis;
    int cnt;

    public int minReorder(int n, int[][] edges) {
        adjList = new ArrayList[n];
        vis = new boolean[n];
        cnt = 0;

        for (int i = 0; i < n; i++) adjList[i] = new ArrayList<>();

        for (int[] e : edges) {
            int u = e[0], v = e[1];
            adjList[u].add(new int[]{v, 1});
            adjList[v].add(new int[]{u, 0});
        }

        dfs(0);
        return cnt;
    }

    private void dfs(int u) {
        vis[u] = true;
        for (int[] e : adjList[u]) {
            int v = e[0], w = e[1];
            if (vis[v]) continue;
            dfs(v);
            cnt += w;
        }
    }
}

