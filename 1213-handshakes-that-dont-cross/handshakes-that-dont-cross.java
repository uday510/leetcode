class Solution {

    private final static int mod = (int) 1e9 + 7;
    public int numberOfWays(int n) {
        int[] dp = new int [n / 2 + 1];
        dp[0] = 1;

        for (int i = 1; i <= n / 2; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += (long) dp[j] * dp[i - j - 1] % mod;
                dp[i] %= mod;
            }
        }

        return dp[n / 2];
    }
}