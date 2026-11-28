class Solution {
    public int minCostII(int[][] costs) {
        int n = costs.length;
        int m = costs[0].length;
        int[][] dp = new int[n][m + 1];
        
        for (int[] r : dp) 
            Arrays.fill(r, -1);
        
        return dfs(0, -1, n, m, costs, dp);
    }

    private int dfs(int i, int k, int n, int m, int[][] costs, int[][] dp) {
        if (i >= n || k >= m) return 0;

        if (dp[i][k + 1] != -1) 
            return dp[i][k + 1];
        
        int cur = Integer.MAX_VALUE;
        for (int j = 0; j < m; j++) {
            if (j == k) continue;

            cur = Math.min(cur, costs[i][j] + dfs(i + 1, j, n, m, costs, dp));
        }

        return dp[i][k + 1] = cur;
    }
}