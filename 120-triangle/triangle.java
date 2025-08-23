class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();

        if (n == 1) return triangle.get(0).get(0);

        int[][] dp = new int[n][n];
        dp[0][0] = triangle.get(0).get(0);
        int min = (int) 1e9;

        for (int i = 1; i < n; ++i) {
            int m = triangle.get(i).size();
            int curr = min;
            for (int j = 0; j < m; ++j) {
                dp[i][j] = triangle.get(i).get(j);
                if(j > 0) {
                    if (j != m - 1) dp[i][j] += Math.min(dp[i - 1][j], dp[i - 1][j - 1]);
                    else dp[i][j] += dp[i - 1][j - 1];
                } 
                else dp[i][j] += dp[i - 1][j];

                curr = Math.min(curr, dp[i][j]);
            }
            if (i == n - 1) min = Math.min(curr, min);
        }

        return min;
    }
}