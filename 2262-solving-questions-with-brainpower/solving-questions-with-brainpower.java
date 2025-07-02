class Solution {

    long[] dp;
    int[][] ques;
    public long mostPoints(int[][] questions) {
        ques = questions;
        dp = new long[questions.length];
        Arrays.fill(dp, -1L);

        return dfs(0);
    }

    private long dfs(int i) {
        if (i >= ques.length) return 0L;

        if (dp[i] != -1L) return dp[i];

        long exc = dfs(i + 1);

        long inc = (long) ques[i][0] + dfs(i + ques[i][1] + 1);

        return dp[i] = (long) Math.max(inc, exc);
    }
    
}