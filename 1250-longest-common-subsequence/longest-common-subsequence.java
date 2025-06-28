class Solution {
    
    int n, m;
    String s1, s2;
    int[][] dp;
    
    public int longestCommonSubsequence(String text1, String text2) {
        n = text1.length();
        m = text2.length();
        s1 = text1;
        s2 = text2;
        dp = new int[n][m];
        for (int[] row : dp) Arrays.fill(row, -1);
        
        return dfs(0, 0);
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