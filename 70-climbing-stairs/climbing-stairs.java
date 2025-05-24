class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return dfs(0, n, dp);
    }
    private int dfs(int i, int n, int[] dp) {
        if (i > n) return 0;
        if (i == n) return 1;
        
        if (dp[i] != -1) return dp[i];

        return dp[i] = dfs(i + 1, n, dp) + dfs(i + 2, n, dp);
    }
}