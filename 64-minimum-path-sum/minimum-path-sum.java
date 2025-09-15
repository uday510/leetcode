class Solution {
    public int minPathSum(int[][] G) {
        int N = G.length, M = G[0].length;
        int[][] dp = new int[N][M];
        int min = (int) 1e9;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                dp[i][j] = G[i][j];
                int l = 0, t = 0;
                if (j > 0) l = dp[i][j - 1];
                if (i > 0) t = dp[i - 1][j];
                if (i > 0 && j > 0) dp[i][j] += Math.min(l, t);
                else dp[i][j] += l + t;

                if (j == M - 1) min = Math.min(min, dp[i][j]);
            }
        }

        return dp[N-1][M-1];
    }
}