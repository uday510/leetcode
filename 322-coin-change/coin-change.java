class Solution {
    public int coinChange(int[] coins, int amt) {
        int[] dp = new int[amt + 1];
        Arrays.fill(dp, amt + 1);

        dp[0] = 0;
        for (int a = 1; a <= amt; a++) {
            for (int c : coins) 
                if (c <= a) dp[a] = Math.min(dp[a], 1 + dp[a - c]);
        }

        return dp[amt] > amt ? -1 : dp[amt];
     }
}