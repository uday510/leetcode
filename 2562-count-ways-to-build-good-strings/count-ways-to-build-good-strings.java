class Solution {

    int[] arr;
    int[] dp;
    int MOD;

    public int countGoodStrings(int low, int high, int zero, int one) {
        this.arr = new int[4];
        arr[0] = low;
        arr[1] = high;
        arr[2] = zero;
        arr[3] = one;
        this.MOD = (int) 1e9 + 7;

        dp = new int[high + 1];

        Arrays.fill(dp, -1);

        return dfs(0);
    }

    private int dfs (int i) {
        if (i > arr[1]) return 0;

        if (dp[i] != -1) return dp[i];

        int cnt = i >= arr[0] ? 1: 0;

        cnt = (cnt + dfs(i + arr[2])) % MOD;
        cnt = (cnt + dfs(i + arr[3])) % MOD;

        return dp[i] = cnt;
    }
}