class Solution {
    int[][] dp; int[][] c;
    int k, n;
    public int minCostII(int[][] costs) {
        c = costs;
        k = c[0].length;
        n = c.length;
        dp = new int[n][k + 1];

        for (int[] r : dp) Arrays.fill(r, -1);

        return dfs(0, -1);
    }

    private int dfs(int i, int exc) {
        if (i >= n) return 0;

        int cur = (int) 1e9;

        if (dp[i][exc + 1] != -1) return dp[i][exc + 1];

        for (int j = 0; j < k; j++) {
            if (j == exc) continue;

            cur = Math.min(cur, c[i][j] + dfs(i + 1, j));
        }

        return dp[i][exc + 1] = cur;
    }
    
}