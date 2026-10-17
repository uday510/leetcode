class Solution {
    public int coinChange(int[] coins, int amt) {
        int[] dp = new int[amt + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        dfs(amt, coins, dp);
        return dp[amt] == (int) 1e9 ? -1 : dp[amt];
    }
    private int dfs(int rem, int[] coins, int[] dp) {
        if (rem < 0) return (int) 1e9;
        if (dp[rem] != -1) return dp[rem];
        if (rem == 0) return 0;

        int cur = (int) 1e9;
        for (int c : coins) {
            cur = Math.min(cur, 1 + dfs(rem - c, coins, dp));
        }

        return dp[rem] = cur;
    }
}