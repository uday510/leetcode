class Solution {

    int low;
    int high;
    int zero;
    int one;
    int cnt;
    int[] dp;
    int MOD;

    public int countGoodStrings(int low, int high, int zero, int one) {
        this.low = low;
        this.high = high;
        this.zero = zero;
        this.one = one;
        this.cnt = 0;
        this.MOD = (int) 1e9 + 7;

        dp = new int[high + 1];

        Arrays.fill(dp, -1);

        return dfs(0);
    }

    private int dfs (int i) {
        if (i > high) return 0;

        if (dp[i] != -1) return dp[i];

        int cnt = i >= low ? 1: 0;

        cnt = (cnt + dfs(i + zero)) % MOD;
        cnt = (cnt + dfs(i + one)) % MOD;

        return dp[i] = cnt;
    }
}