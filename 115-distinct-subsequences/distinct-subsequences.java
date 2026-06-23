class Solution {
    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();

        int[][] dp = new int[n][m];
        for (int[] r : dp) Arrays.fill(r, -1);

        return dfs(0, 0, n, m, s, t, dp);
    }

    private int dfs(int i, int j, int n, int m, String s, String t, int[][] dp) {
        if (j >= m) return 1;
        if (i >= n) return 0;

        if (dp[i][j] != -1) return dp[i][j];

        int cur;
        if (s.charAt(i) == t.charAt(j)) {
            cur = dfs(i + 1, j + 1, n, m, s, t, dp) + dfs(i + 1, j, n, m, s, t, dp);
        } else {
            cur = dfs(i + 1, j, n, m, s, t, dp);
        }

        return dp[i][j] = cur;
    }
}