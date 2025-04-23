class Solution {
    int[] prices;
    int[] dp;
    int n;
    public int maxProfit(int[] prices) {
        this.prices = prices;
        n = prices.length;
        dp = new int[n];
        Arrays.fill(dp, -1);

        return dfs(0);
    }

    private int dfs(int idx) {
        if (idx >= n) return 0;
        if (dp[idx] != -1) return dp[idx];
        int max = 0;

        for (int i = idx; i < n; ++i) {
            int curr = prices[i] - prices[idx] + dfs(i + 1);
            max = Math.max(max, curr);
        }

        return dp[idx] = max;
    }
}