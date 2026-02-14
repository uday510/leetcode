class Solution {

    private int[][] costs;
    private int[][] dp;
    private int k, n;

    public int minCost(int[][] costs) {
        this.costs = costs;
        k = costs[0].length;
        n = costs.length;
        dp = new int[n][k + 1];

        for (int[] row : dp) Arrays.fill(row, -1);

        return dfs(0, -1);    
    }

    private int dfs(int i, int exc) {
        if (i >= n) return 0;

        if (dp[i][exc + 1] != -1) return dp[i][exc + 1];

        int cur = (int) 1e9 + 1;
        for (int j = 0; j < k; j++) {
            if (j == exc) continue;

            cur = Math.min(cur, costs[i][j] + dfs(i + 1, j));
        }

        return dp[i][exc + 1] = cur;
    }
}