class Solution {

    int[] dp;
    int INF = 0x7ffffff;

    public int numSquares(int n) {
        dp = new int[n + 1];
        Arrays.fill(dp, -1);

        return dfs(n);
    }
    private int dfs(int n) {
        if (n < 0) return INF;
        if (n == 0) return 0;

        if (dp[n] != -1) return dp[n];

        int min = n;
        for (int i = 1; i * i <= n; i++) {
            int cur = dfs(n - i * i);
            if (cur != INF) min = Math.min(min, 1 + cur);
        }

        return dp[n] = min;
    }
}