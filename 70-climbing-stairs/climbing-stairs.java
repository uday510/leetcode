class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int idx = 2; idx < n + 1; ++idx) {
            dp[idx] = dp[idx - 1] + dp[idx - 2];
        }

        return dp[n];
    }
}