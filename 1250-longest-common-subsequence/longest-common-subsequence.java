class Solution {
    public int longestCommonSubsequence(String s1, String s2) {
        
        int n = s1.length(), m = s2.length();

        int[][] dp = new int[n][m];
        for (int[] r : dp) Arrays.fill(r, -1);
    
        return dfs(0, 0, n, m, s1, s2, dp);
    }

    private int dfs(int i, int j, int n, int m, String s1, String s2, int[][] dp) {
        if (i >= n || j >= m) return 0;

        if (dp[i][j] != -1) return dp[i][j];

        char c1 = s1.charAt(i), c2 = s2.charAt(j);

        if (c1 == c2) {
            dp[i][j] = 1 + dfs(i + 1, j + 1, n, m, s1, s2, dp);
        } else {
            dp[i][j] = Math.max(
                dfs(i + 1, j, n, m, s1, s2, dp),
                dfs(i, j + 1, n, m, s1, s2, dp)
            );
        }

        return dp[i][j];
    }
}