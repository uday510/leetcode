class Solution {
    public int superEggDrop(int k, int n) {
        int[][] dp = new int[k + 1][n + 1];

        for (int i = 1; i <= k; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == 1) {
                    dp[i][j] = j;
                } else if (j == 1) {
                    dp[i][j] = 1;
                } else {
                    int cur = Integer.MAX_VALUE;

                    int l = 1, r = j;
                    while (l <= r) {
                        int m = l + ((r - l) >> 1);
                        int t1 = dp[i - 1][m - 1];
                        int t2 = dp[i][j - m];
                        int t3 = Math.max(t1, t2);
                        cur = Math.min(cur, t3);

                        if (t1 < t2) l = m + 1;
                        else r = m - 1;
                    }
                    dp[i][j] = cur + 1;
                }
            }
        }
        return dp[k][n];
    }
}