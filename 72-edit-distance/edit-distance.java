class Solution {
    public int minDistance(String w1, String w2) {
        
        int n = w1.length();
        int m = w2.length();
        int[][] dp = new int[n][m];

        for (int[] r : dp) Arrays.fill(r, -1);

        return dfs(0, 0, n, m, w1, w2, dp);
    }

    private int dfs(
        int i,
        int j,
        int n,
        int m,
        String w1,
        String w2,
        int[][] dp
    ) {
        
        if (i >= n && j >= m) return 0;
        if (i >= n) return m - j;
        if (j >= m) return n - i;

        if (dp[i][j] != -1) return dp[i][j];

        int cur = n + m;

        if (w1.charAt(i) == w2.charAt(j)) {
            cur = dfs(i + 1, j + 1, n, m, w1, w2, dp);
        } else {
            int ins = dfs(i + 1, j, n, m, w1, w2, dp);
            int del = dfs(i, j + 1, n, m, w1, w2, dp);
            int repl = dfs(i + 1, j + 1, n, m, w1, w2, dp);

            int t = Math.min(ins, Math.min(del, repl)) + 1;

            cur = Math.min(t, cur);
        }

        return dp[i][j] = cur;
    }

}