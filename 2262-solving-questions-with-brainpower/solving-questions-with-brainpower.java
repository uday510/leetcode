class Solution {
    long[] dp;
    int[][] ques;
    public long mostPoints(int[][] questions) {
        ques = questions;
        dp = new long[questions.length];
        Arrays.fill(dp, -1l);
        return dfs(0);
    }
    private long dfs(int i) {
        if (i >= ques.length) return 0l;

        if (dp[i] != -1l) return dp[i];

        long exc = dfs(i + 1);
    
        long inc = ques[i][0]*1l + dfs(i + ques[i][1] + 1);

        return dp[i] = (long) Math.max(inc, exc);
    }
}