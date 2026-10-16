class Solution {
    public int maxProfit(int[] prices) {
        
        int n = prices.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);

        int mx = 0;
        for (int i = 1; i < n; i++) {
            int cur = Math.max(prices[i] - prices[i - 1], 0);
            mx += cur;
        }

        return mx;

        // return dfs(0, n, prices, dp);
    }

    private int dfs(int i, int n, int[] p, int[] dp) {
        if (i >= n) return 0;

        if (dp[i] != -1) return dp[i];

        int mx = 0;
        for (int j = i; j < n; j++) {
            int cur = p[j] - p[i] + dfs(j + 1, n, p, dp);
            mx = Math.max(mx, cur);
        }

        return dp[i] = mx;
    }
}