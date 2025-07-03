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
        MOD = (int) 1e9 + 7;

        dp = new int[high + 1];

        Arrays.fill(dp, -1);

        return dfs(0);
    }

    private int dfs (int curr) {
        if (curr > high) return 0;

        if (dp[curr] != -1) return dp[curr];

        if (curr >= low && curr <= high) {
           return dp[curr] = 1 + (dfs(curr + zero) + dfs(curr + one)) % MOD;
        }

        return dp[curr] = (dfs(curr + zero) + dfs(curr + one)) % MOD;
    }
}