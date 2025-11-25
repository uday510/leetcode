class Solution {
    public int coinChange(int[] C, int A) {
        int n = C.length;
        int[] dp = new int[A + 1];

        for (int a = 1; a <= A; a++) {
            dp[a] = A + 1;

            for (int c : C) {
                if (a - c >= 0) {
                    dp[a] = Math.min(dp[a], 1 + dp[a - c]);
                }
            }
        }

        return dp[A] > A ? -1 : dp[A];
    }
}