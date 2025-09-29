class Solution {
    int[] p, dp;
    int n;
    public int maxProfit(int[] prices) {
        p = prices; 
        n = p.length;
        dp = new int[n];

        Arrays.fill(dp, -1);

        return dfs(0);
    }

    private int dfs(int i) {
        if (i >= n) return 0;
        int max = 0;

        if (dp[i] != -1) return dp[i];

        for (int j = i; j < n; j++) {
            int cur = p[j] - p[i] + dfs(j + 1);

            max = Math.max(max, cur);
        }

        return dp[i] = max;
    }
}