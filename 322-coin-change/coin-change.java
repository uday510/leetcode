class Solution {
    public int coinChange(int[] coins, int amt) {
        if (coins.length == 0 || amt == 0) return 0;
        int[] dp = new int[amt + 1];
        Arrays.fill(dp, amt + 1);
        dp[0] = 0;

        for (int c : coins) {
            for (int i = c; i <= amt; i++) {
                dp[i] = Math.min(dp[i], dp[i - c] + 1);
            }
        }

        return dp[amt] > amt ? -1 : dp[amt];
    }
}