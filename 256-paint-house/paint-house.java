class Solution {
    int[][] costs;
    int[][] dp;
    public int minCost(int[][] costs) {
        this.costs = costs;
        dp = new int[costs.length][4];
        for (int[] row :dp) Arrays.fill(row, -1);

        return dfs(0, -1);
    }

    private int dfs(int i, int exc) {
        if (i >= costs.length) return 0;

        if (dp[i][exc + 1] != -1) return dp[i][exc + 1];

        int curr = (int) 1e9;

        for (int j = 0; j < costs[i].length; ++j) {
            if (j == exc) continue;

            curr = Math.min(curr, costs[i][j] + dfs(i + 1, j));
        }

        return dp[i][exc + 1] = curr;
    }
}