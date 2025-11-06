class Solution {

    int[][] q;
    long[] dp;
    int n;

    public long mostPoints(int[][] q) {
        this.q = q;
        n = q.length;
        this.dp = new long[n];
        Arrays.fill(dp, -1);

        return dfs(0);
    }
    private long dfs(int i) {
        if (i >= n) return 0;

        if (dp[i] != -1) return dp[i];

        long skip = dfs(i + 1);
        long pick = q[i][0] + dfs(i + q[i][1] + 1);

        return dp[i] = Math.max(skip, pick);
    }
}