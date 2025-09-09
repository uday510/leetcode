class Solution {
    public int minCost(int[][] c) {
        int n = c.length;
        int[][] dp = new int[n + 1][3];

        for (int i = n - 1; i > -1; i--) {
            dp[i][0] = c[i][0] + Math.min(dp[i + 1][1], dp[i + 1][2]);
            dp[i][1] = c[i][1] + Math.min(dp[i + 1][0], dp[i + 1][2]);
            dp[i][2] = c[i][2] + Math.min(dp[i + 1][0], dp[i + 1][1]);
        }

        return Math.min(dp[0][0], Math.min(dp[0][1], dp[0][2]));
    }
}