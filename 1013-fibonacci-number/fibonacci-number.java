class Solution {
    int[] dp;
    public int fib(int n) {
        dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return dfs(n);
    }
    private int dfs(int n) {
        if (n < 2) {
            return n;
        }

        if (dp[n] != -1) {
            return dp[n];
        }

        return dp[n] = dfs(n - 1) + dfs(n - 2);
    }
}