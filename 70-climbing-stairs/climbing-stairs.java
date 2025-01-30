class Solution {
    int[] dp;
    public int climbStairs(int n) { 
        dp = new int[n + 1];
        Arrays.fill(dp, -1);
        dp[1] = 1;
        return dfs(n);
    }
    private int dfs(int n) {
        if (n == 0) {
            return 1;
        } 
        if (n < 0) {
            return 0;
        }

        if (dp[n] != -1) {
            return dp[n];
        }

        return dp[n] = dfs(n - 1) + dfs(n - 2);
    }
}