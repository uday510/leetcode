class Solution {

    private int[] coins, dp;

    public int coinChange(int[] coins, int amount) {
        this.coins = coins;
        this.dp = new int[amount + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;

        dfs(amount);  

        return dp[amount] == (int) 1e9 ? -1 : dp[amount];
    }

    private int dfs(int amt) {
        if (amt < 0) return (int) 1e9;
        if (dp[amt] != -1) return dp[amt];

        int cur = (int) 1e9;
        for (int c : coins) {
            cur = Math.min(cur, 1 + dfs(amt - c));
        }

        return dp[amt] = cur;
    }
}