class Solution {

    int r, c;
    int[][] dp;

    public int minPathSum(int[][] g) {
        r = g.length;
        c = g[0].length;
        dp = new int[r][c];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                dp[i][j] = g[i][j] + getMin(i, j);
            }
        }

        return dp[r - 1][c - 1];
    }

    private int getMin(int i, int j) {
        int cur = 0;

        if (i > 0 && j > 0) {
            cur = Math.min(dp[i - 1][j], dp[i][j - 1]);
        } else if (i > 0) {
            cur = dp[i - 1][j];
        } else if (j > 0) {
            cur = dp[i][j - 1];
        }

        return cur;

    }

}