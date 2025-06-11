class Solution {

    int m;
    int n;

    int[][] dp;

    public int minDistance(String word1, String word2) {
        m = word1.length();
        n = word2.length();

        dp = new int[m][n];
        for (var row : dp) Arrays.fill(row, -1);

        return dfs(0, 0, word1, word2);
    }
    private int dfs(int i, int j, String s1, String s2) {
        if (i >= s1.length()) return n - j;

        if (j >= s2.length()) return m - i;

        if (dp[i][j] != -1) return dp[i][j];

        if (s1.charAt(i) == s2.charAt(j)) {
            return dp[i][j] = dfs(i + 1, j + 1, s1, s2);
        };

        int ins = dfs(i, j + 1, s1, s2);
        int del = dfs(i + 1, j, s1, s2);
        int rep = dfs(i + 1, j + 1, s1, s2);

        return dp[i][j] = 1 + Math.min(ins, Math.min(del, rep));
    }
}