class Solution {
    
    int n, m;
    String s1, s2;
    int[][] dp;
    
    public int longestCommonSubsequence(String text1, String text2) {
        n = text1.length();
        m = text2.length();
        s1 = text1;
        s2 = text2;
        dp = new int[n + 1][m + 1];

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    dp[i][j] = 1 + (i > 0 && j > 0 ? dp[i - 1][j - 1] : 0);
                } else {
                    int p1 = (i > 0 ? dp[i - 1][j] : 0);
                    int p2 = (j > 0 ? dp[i][j - 1] : 0);
                    dp[i][j] = Math.max(p1, p2);
                }
            }
        }
        
       return dp[n - 1][m - 1];
    }
    private int dfs(int i, int j) {
        if (i >= n || j >= m) return 0;
        
        if (dp[i][j] != -1) return dp[i][j];
        
        if (s1.charAt(i) == s2.charAt(j)) {
            dp[i][j] = 1 + dfs(i + 1, j + 1);
        } else {
            dp[i][j] = Math.max(dfs(i, j + 1), dfs(i + 1, j));
        }
        
        return dp[i][j];
    }
}