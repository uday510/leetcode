class Solution {

    int[] dp;

    public int numSquares(int n) {
        dp = new int[n + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        dp[1] = 1;

        return dfs(n);  
    }

    private int dfs(int n) {
        if (n < 0) return -1;
        if (n == 0) return 0;

        if (dp[n] != -1) return dp[n];

        int min = (int) 1e9;
        for (int i = 1; i * i <= n; i++) {
            int cur = dfs(n - i * i);
            if (cur != -1) min = Math.min(min, cur + 1);
        }

        return dp[n] = min;
    }
}