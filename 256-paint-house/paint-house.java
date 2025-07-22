class Solution {

    int[][] costs;
    int[][] dp;
    int n;

    public int minCost(int[][] costs) {
        this.costs = costs;
        n = costs.length;
        this.dp = new int[n][3];
        
        for (int[] row : dp) Arrays.fill(row, -1);

        return Math.min(dfs(0, 0), Math.min(dfs(0, 1), dfs(0, 2)));
    }

    private int dfs(int i, int color) {
        if (i >= n) return 0;

        if (dp[i][color] != -1) return dp[i][color];

        int curr = (int) 1e9;

        if (color == 0) {
            curr = Math.min(dfs(i + 1, 1), dfs(i + 1, 2));
        } else if (color == 1) {
            curr = Math.min(dfs(i + 1, 0), dfs(i + 1, 2));
        } else if (color == 2) {
            curr = Math.min(dfs(i + 1, 0), dfs(i + 1, 1));
        }

        curr += costs[i][color];

        return dp[i][color] = curr;
    }
}