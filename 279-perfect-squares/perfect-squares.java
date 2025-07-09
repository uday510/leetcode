class Solution {

    int[] dp;
    public int numSquares(int n) {
        dp = new int[n + 1];
        Arrays.fill(dp, -1);

        return dfs(n) - 1;
    }

    private int dfs (int rem) {
        if (rem < 0) return 0;
        if (rem == 0) return 1;

        if (dp[rem] != -1) return dp[rem];

        int min = (int) 1e9;
        for (int i = 1; i * i <= rem; ++i) {
            min = Math.min(min, 1 + dfs(rem - i * i));
        }

        return dp[rem] = min;
    }
}