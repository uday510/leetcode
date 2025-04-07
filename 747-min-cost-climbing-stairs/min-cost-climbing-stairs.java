class Solution {
    int[] cost;
    int[] dp;
    public int minCostClimbingStairs(int[] cost) {
        this.cost = cost;
        this.dp = new int[cost.length];
        Arrays.fill(dp, -1);
        return Math.min(dfs(0), dfs(1));
    }
    private int dfs(int idx) {
        if (idx >= cost.length) return 0;
        if (dp[idx] != -1) return dp[idx];

        int t1 = dfs(idx + 1);
        int t2 = dfs(idx + 2);
        
        return dp[idx] = Math.min(t1, t2) + cost[idx];
    }
}