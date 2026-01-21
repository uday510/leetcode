class Solution {

    int[] coins;
    int n;
    int[] dp;

    public int coinChange(int[] coins, int amount) {
        this.coins = coins;
        this.n = coins.length;
        this.dp = new int[amount + 1];

        Arrays.fill(dp, -1);

        dp[0] = 0;

        dfs(amount);

        return dp[amount] == (int) 1e9 ? -1 : dp[amount];
    }
    private int dfs(int amt) {
        if (amt == 0) return 0;
        if (amt < 0) return (int) 1e9;

        if (dp[amt] != -1) return dp[amt];

        int cur = (int) 1e9;
        for (int coin : coins) {
            cur = Math.min(cur, 1 + dfs(amt - coin));
        }

        return dp[amt] = cur;
    }
}