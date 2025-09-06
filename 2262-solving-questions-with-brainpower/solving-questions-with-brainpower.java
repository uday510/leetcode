class Solution {
    int[][] A;
    int n;
    long[] dp;
    public long mostPoints(int[][] questions) {
        A = questions;
        n = A.length;
        dp = new long[n + 1];
        // Arrays.fill(dp, -1l);

        // return dfs(0);

        for (int i = n - 1; i > -1; i--) {
            int[] q = A[i];

            long exc = dp[i + 1];
            long inc = q[0] + (q[1] + i + 1 < n ? dp[q[1] + i + 1] : 0);

            dp[i] = Math.max(inc, exc);
        }
        return dp[0];
    }

    private long dfs (int i) {
        if (i >= n) return 0;

        if (dp[i] != -1) return dp[i];

        long skip = dfs(i + 1);
        long take = A[i][0] + dfs(i + A[i][1] + 1);

        return dp[i] = Math.max(skip, take);
    }
}