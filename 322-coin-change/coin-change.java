class Solution {
    int[] coins;
    int[] dp;
    int n;
    public int coinChange(int[] coins, int amt) {
        this.coins = coins;
        n = coins.length;
        dp = new int[amt + 1];
        Arrays.fill(dp, -1);

        int res = dfs(amt);

        return res == (int) 1e9 ? -1 : res;
    }
    private int dfs(int amt) {
        if (amt < 0) return -1;
        if (amt == 0) return 0;

        if (dp[amt] != -1) return dp[amt];

       int min = (int) 1e9;
       for (int c : coins) {
            int cur = dfs(amt - c);
            if (cur != -1) min = Math.min(min, 1 + cur);
       }

       return dp[amt] = min;
    }
}