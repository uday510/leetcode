class Solution {
    String s;
    int n;
    int[][] dp;
    public int minInsertions(String s) {
        this.s = s;
        n = s.length();
        dp = new int[n][n];
        
        for (int[] row : dp) Arrays.fill(row, -1);

        return dfs(0, n - 1);
    }

    private int dfs(int l, int r) {
        if (l > r) return 0;

        if (dp[l][r] != -1) return dp[l][r];

        if (s.charAt(l) == s.charAt(r)) {
            dp[l][r] = dfs(l + 1, r - 1);
        } else {
            dp[l][r] = 1 + Math.min(dfs(l + 1, r), dfs(l, r - 1));
        }

        return dp[l][r];
    }
}