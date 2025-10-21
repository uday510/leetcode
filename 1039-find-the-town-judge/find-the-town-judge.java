class Solution {
    public int findJudge(int n, int[][] edges) {
        int[] outdegree = new int[n + 1];
        int[] indegree = new int[n + 1];

        for (int[] e : edges) {
            int u = e[0], v = e[1];

            outdegree[u]++;
            indegree[v]++;
        }

        for (int i = 1; i <= n; i++) {
            if (outdegree[i] == 0 && indegree[i] == n - 1) {
                return i;
            }
        }

        return -1;
    }
}