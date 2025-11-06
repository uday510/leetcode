class Solution {
    int[] coins;
    int inf = (int) 1e9;
    int[] dp;

    public int coinChange(int[] coins, int amount) {
        this.coins = coins;
        dp = new int[amount + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;

        dfs(amount);
        
        return dp[amount] == inf ? -1 : dp[amount];
    }
    private int dfs(int req) {
        if (req < 0) return (int) 1e9;

        if (dp[req] != -1) return dp[req];

        int cur = inf;
        for (int c : coins) {

            cur = Math.min(cur, 1 + dfs(req - c));
        }

        return dp[req] = cur;
    }
}