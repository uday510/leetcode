class Solution {
    int[] dp;
    int[] coins;
    public int coinChange(int[] coins, int amount) {
        dp = new int[amount + 1];
        this.coins = coins;
        Arrays.fill(dp, -2);

        return dfs(amount);
    }

    private int dfs(int rem) {
        if (rem == 0) return 0;
        if (rem < 0) return -1;

        if (dp[rem] != -2) return dp[rem];

        int min = (int) 1e9;
        for (int coin : coins) {
            int res = dfs(rem - coin);
            if (res >= 0) {
                min = Math.min(min, res + 1);
            }
        }

        return dp[rem] = (min == (int) 1e9 ? -1 : min);
    }
}