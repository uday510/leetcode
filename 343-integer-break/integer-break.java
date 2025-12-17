class Solution {
    int[] dp;

    public int integerBreak(int n) {
        dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return dfs(n);
    }

    private int dfs(int n) {
        if (n == 1) return 1;
        if (dp[n] != -1) return dp[n];

        int best = 0;
        for (int i = 1; i < n; i++) {
            best = Math.max(best, i * Math.max(n - i, dfs(n - i)));
        }
        return dp[n] = best;
    }
}
