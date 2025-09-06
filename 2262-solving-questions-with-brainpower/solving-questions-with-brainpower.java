class Solution {
    int[][] A;
    int n;
    long[] dp;
    public long mostPoints(int[][] questions) {
        A = questions;
        n = A.length;
        dp = new long[n];
        Arrays.fill(dp, -1l);

        return dfs(0);
    }

    private long dfs (int i) {
        if (i >= n) return 0;

        if (dp[i] != -1) return dp[i];

        long skip = dfs(i + 1);
        long take = A[i][0] + dfs(i + A[i][1] + 1);

        return dp[i] = Math.max(skip, take);
    }
}