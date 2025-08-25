class Solution {
    int[][] dp;
    String s1, s2;
    int m, n;
    public int longestCommonSubsequence(String text1, String text2) {
        s1 = text1;
        s2 = text2;
        m = s1.length();
        n = s2.length();

        dp = new int[m][n];
        for (int[] row : dp) Arrays.fill(row, -1);

        return dfs(0, 0);
    }

    private int dfs(int i, int j) {
        if (i >= m || j >= n) return 0;

        if (dp[i][j] != -1) return dp[i][j];
        if (s1.charAt(i) == s2.charAt(j)) {
            dp[i][j] = 1 + dfs(i + 1, j + 1);
        } else {
            dp[i][j] = Math.max(dfs(i, j + 1), dfs(i + 1, j));
        }

        return dp[i][j];
    }
}