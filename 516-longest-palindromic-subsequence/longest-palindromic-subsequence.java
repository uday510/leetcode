class Solution {
    public int longestPalindromeSubseq(String s) {
        
        int n = s.length();
        int[][] dp = new int[n][n];

        for (int[] r : dp) Arrays.fill(r, -1);

        return dfs(0, n - 1, s, dp);
    }

    private int dfs(int l, int r, String s, int[][] dp) {
        if (l > r) return 0;
        if (l == r) return 1;

        if (dp[l][r] != -1) {
            return dp[l][r];
        }

        if (s.charAt(l) == s.charAt(r)) {
            return dp[l][r] = 2 + dfs(l + 1, r - 1, s, dp);
        }

        return dp[l][r] = Math.max(
            dfs(l + 1, r, s, dp),
            dfs(l, r - 1, s, dp)
        );

    }
}