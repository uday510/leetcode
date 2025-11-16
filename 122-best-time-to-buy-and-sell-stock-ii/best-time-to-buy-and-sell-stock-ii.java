class Solution {

    int[] dp, p;
    int n;

    public int maxProfit(int[] prices) {
        n = prices.length;
        p = prices;
        dp = new int[n];
        Arrays.fill(dp, -1);

        return dfs(0);
    }

    private int dfs(int i) {
        if (i >= n) return 0;

        if (dp[i] != -1) return dp[i];

        int mx = 0;
        for (int j = i; j < n; j++) {
            int cur = p[j] - p[i] + dfs(j + 1);
            mx = Math.max(mx, cur); 
        }

        return dp[i] = mx;
    }
}