class Solution {
    public int change(int amt, int[] coins) {
        int[] dp = new int[amt + 1];
        dp[0] = 1;

        for (int c : coins) {
            for (int a = c; a <= amt; a++) {
                dp[a] += dp[a - c];
            }
        }

        return dp[amt];
    }
}