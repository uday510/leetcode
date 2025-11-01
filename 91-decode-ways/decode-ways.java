class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        if (n == 0 || s.charAt(0) == '0') return 0;

        int[] dp = new int[n + 1];
        dp[0] = dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            int one = s.charAt(i - 1) - '0';
            int two = (s.charAt(i - 2) - '0') * 10 + one;

            if (one >= 1) dp[i] = dp[i - 1];
            if (two >= 10 && two <= 26) dp[i] += dp[i - 2];
        }

        return dp[n];
    }
}