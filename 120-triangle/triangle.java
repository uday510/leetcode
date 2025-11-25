class Solution {
    public int minimumTotal(List<List<Integer>> T) {
        int n = T.size();

        if (n == 1) return T.get(0).get(0);

        int[][] dp = new int[n][n];
        dp[0][0] = T.get(0).get(0);
        int min = (int) 1e9;

        for (int i = 1; i < n; i++) {
            int m = T.get(i).size();
            int cur = min;
            
            for (int j = 0; j < m; j++) {
                dp[i][j] = T.get(i).get(j);

                if (j > 0) {
                    if (j != m - 1) dp[i][j] += Math.min(dp[i - 1][j], dp[i - 1][j - 1]);
                    else dp[i][j] += dp[i - 1][j - 1];
                } else {
                    dp[i][j] += dp[i - 1][j];
                }
                
                cur = Math.min(cur, dp[i][j]);
            }

            if (i == n - 1) min = Math.min(min, cur);
        }

        return min;
    }
}