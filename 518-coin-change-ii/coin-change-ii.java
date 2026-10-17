class Solution {

    public int change(int amt, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n][amt + 1];

        for (int[] r : dp) Arrays.fill(r, -1);

        return dfs(0, n, amt, coins, dp);
    }

    private int dfs(int i, int n, int rem, int[] coins, int[][] dp) {
        if (rem == 0) return 1;
        if (rem < 0 || i >= n) return 0;

        if (dp[i][rem] != -1) return dp[i][rem];

        int inc = dfs(i, n, rem - coins[i], coins, dp);
        int exc = dfs(i + 1, n, rem, coins, dp);

        return dp[i][rem] = inc + exc;
    }
}