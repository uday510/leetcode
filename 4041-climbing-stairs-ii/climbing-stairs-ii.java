class Solution {
    public int climbStairs(int n, int[] costs) {
        
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);

        return dfs(0, n, costs, dp);
    }
    private int dfs(int i, int n, int[] costs, int[] dp) {
        if (i >= n) return 0;

        if (dp[i] != -1) return dp[i];

        int cur = Integer.MAX_VALUE;
        for (int j = i; j < Math.min(n, i + 3); j++) {
            int k = j - i + 1;
            int t1 = k * k + dfs(j + 1, n, costs, dp);
            cur = Math.min(cur, costs[j] + t1);
        }
    
        return dp[i] = cur;
    }
}