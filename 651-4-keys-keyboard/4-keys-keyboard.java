class Solution {
    
    private int[] dp;

    public int maxA(int n) {
        dp = new int[n + 1];
        Arrays.fill(dp, -1);

        return dfs(n);
    }

    private int dfs(int n) {
        if (n <= 6) return dp[n] = n;

        if (dp[n] != -1) return dp[n];

        int cur = n;
        for (int i = 2; i <= n; i++) {
            int remOps = n - i + 1;
            cur = Math.max(cur, dfs(i - 2) * remOps);
        }

        return dp[n] = cur;
    }
}