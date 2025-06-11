class Solution {
    
    int[][] dp;
    int m;
    int n;
    
    public int numDistinct(String s, String t) {
        m = s.length();
        n = t.length();

        dp = new int[m][n];

        for (var row : dp) Arrays.fill(row, -1);

        dfs(0, 0, s, t);

        return dp[0][0];
    }

    private int dfs(int i, int j, String s, String t) {
        if (j >= n) return 1;
        if (i >= m) return 0;

        if (dp[i][j] != -1) return dp[i][j];

        if (s.charAt(i) == t.charAt(j)) {
            dp[i][j] = dfs(i + 1, j + 1, s, t) + dfs(i + 1, j, s, t);
        } else {
            dp[i][j] = dfs(i + 1, j, s, t);
        }

        return dp[i][j];
    }

}