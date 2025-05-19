class Solution {
    List<int[]>[] adjList;
    int[] signals;
    int INFINITY = (int) 1e9;
    public int networkDelayTime(int[][] times, int n, int k) {
        adjList = new ArrayList[n + 1];
        signals = new int[n + 1];
        Arrays.fill(signals, INFINITY);

        for (int i = 1; i <= n; ++i) {
            adjList[i] = new ArrayList<>();
        }

        for (int[] time : times) {
            adjList[time[0]].add(new int[] {time[1], time[2]});
        }

        dfs(k, 0);

        int max = -INFINITY;

        for (int idx = 1; idx <= n; ++idx) {
            if (signals[idx] == INFINITY) return -1;
            max = Math.max(max, signals[idx]);
        }

        return max;
    }

    private void dfs(int node, int curr) {
        if (curr >= signals[node]) return;

        signals[node] = curr;

        for (int[] next : adjList[node]) {
            dfs(next[0], curr + next[1]);
        }

    }
}