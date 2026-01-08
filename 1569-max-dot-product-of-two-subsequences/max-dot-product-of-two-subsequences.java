class Solution {
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m =nums2.length;

        int[][] dp = new int[n][m];

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                int p = nums1[i] * nums2[j];
                dp[i][j] = p;

                dp[i][j] = i > 0 ? Math.max(dp[i][j], dp[i-1][j]) : dp[i][j];
                
                dp[i][j] = j > 0 ? Math.max(dp[i][j], dp[i][j-1]) : dp[i][j];

                dp[i][j] = i > 0 && j > 0 ? Math.max(dp[i][j], p + dp[i-1][j-1]) : dp[i][j];

            }

        }

        return dp[n-1][m-1];
    }
}
