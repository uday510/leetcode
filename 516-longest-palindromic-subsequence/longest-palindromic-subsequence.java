class Solution {

    String s;
    int n;
    int[][] dp;

    public int longestPalindromeSubseq(String s) {
        this.s = s;
        n = s.length();
        dp = new int[n][n];

        for (int[] row : dp) Arrays.fill(row, -1);

        return dfs(0, s.length() - 1);
    }
    private int dfs(int l, int r) {
        if (l > r) return 0;
        if (l == r) return 1;
        
        if (dp[l][r] != -1) return dp[l][r];

        int curr = 0;
        if (s.charAt(l) == s.charAt(r)) {
            curr = 2 + dfs(l + 1, r - 1);
        } else {
            curr = Math.max(dfs(l, r - 1), dfs(l + 1, r));
        }

        return dp[l][r] = curr;
    }
}