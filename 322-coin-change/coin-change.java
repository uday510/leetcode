class Solution {
    public int coinChange(int[] C, int A) {
        int n = C.length;
        int[] dp = new int[A + 1];

        for (int amt = 1; amt <= A; amt++) {
            dp[amt] = A + 1;
            for (int c : C) {
                int req = amt - c;
                if (req >= 0) {
                    dp[amt] = Math.min(dp[amt], dp[req] + 1);
                }
            }
        }

        return dp[A] > A ? -1 : dp[A];
    }
}