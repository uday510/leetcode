class Solution {
    public long mostPoints(int[][] ques) {
        int n = ques.length;
        long[] dp = new long[n + 1];

        for (int i = n - 1; i > -1; --i) {
            int points = ques[i][0];
            int skip = ques[i][1];
            int skipIdx = i + skip + 1;

            long inc = points + (skipIdx < n ? dp[skipIdx] : 0);
            long exc = dp[i + 1];

            dp[i] = Math.max(inc, exc);
        }

        return dp[0];
    }
}