class Solution {
    int MOD = (int) 1e9 + 7;
    int[] dp;
    public int countGoodStrings(int low, int high, int zero, int one) {
        dp = new int[high + 1];
        
        Arrays.fill(dp, -1);

        return dfs(0, low, high, zero, one);
    }
    private int dfs(int index, int low, int high, int zero, int one) {
        if (index > high) {
            return 0;
        }

        if (dp[index] != -1) {
            return dp[index];
        }

        int count = index >= low ? 1 : 0;

        count = (count + dfs(index + zero, low, high, zero, one)) % MOD;
        count = (count + dfs(index + one, low, high, zero, one)) % MOD;

        return dp[index] = count;
    }
}