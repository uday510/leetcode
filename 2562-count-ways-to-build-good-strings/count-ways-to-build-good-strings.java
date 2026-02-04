class Solution {

    private int l, h, z, o;
    private int[] dp;
    private final int MOD = (int) 1e9 + 7;

    public int countGoodStrings(int low, int high, int zero, int one) {
        l = low; 
        h = high;
        z = zero;
        o = one;
        dp = new int[h + 1];
        Arrays.fill(dp, -1);

        return dfs(0);
    }

    private int dfs(int idx) {
        if (idx > h) return 0;

        if (dp[idx] != -1) return dp[idx];

        int cur = idx >= l ? 1 : 0;

        cur += dfs(idx + z) % MOD + dfs(idx + o) % MOD;

        return dp[idx] = cur % MOD;
    }
}