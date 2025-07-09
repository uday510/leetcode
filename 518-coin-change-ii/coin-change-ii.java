class Solution {

    // int[][] dp;
    int[] coins;
    int n;

    public int change(int amount, int[] coins) {
        // this.coins = coins;
        this.n = coins.length;
        // dp = new int[n][amount + 1];

        // for (int[] row : dp) Arrays.fill(row, -1);

        // return dfs(0, amount);
        int[] dp = new int[amount + 1];
        dp[0] = 1;

        for (int coin : coins) {
            for (int rem = 1; rem <= amount; ++rem) {
                if (coin <= rem) {
                    dp[rem] += dp[rem-coin];
                }
            }
        }
        return dp[amount];

    }
    // private int dfs(int i, int rem) {
    //     if (rem == 0) return 1;
    //     if (rem < 0 || i >= coins.length) return 0;
        
    //     if (dp[i][rem] != -1) return dp[i][rem];

    //     int inc = dfs(i, rem - coins[i]);
    //     int exc = dfs(i + 1, rem);

    //     return dp[i][rem] = inc + exc;
    // }
}