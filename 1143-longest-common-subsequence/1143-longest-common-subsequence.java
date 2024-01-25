class Solution {
    // int[][] dp;
    public int longestCommonSubsequence(String text1, String text2) {
        // dp = new int[text1.length()][text2.length()];
//         for (int[] arr : dp) Arrays.fill(arr,-1);
//         return dfs(text1, text2, text1.length()-1, text2.length()-1);
        
        int n = text1.length();
        int m = text2.length();
        int[][] dp = new int[n+1][m+1];
        
        // if (text1.charAt(n-1) == text1.charAt(m-1)) dp[n-1][m-2] = 1;
        
        for (int i = n-1; i >= 0; --i) {
            for (int j = m-1; j >= 0; --j) {
                char c1 = text1.charAt(i);
                char c2 = text2.charAt(j);
                
                if (c1 == c2) {
                     dp[i][j] = 1 + dp[i+1][j+1];
                } else {
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j+1]);
                }
            }
        }
        return dp[0][0];
    }
//     public int dfs(String s1, String s2, int pos1, int pos2) {
//         if (pos1 < 0 || pos2 < 0) return 0;
        
//         if (dp[pos1][pos2] != -1) return dp[pos1][pos2];
//         int longest = 0;
//         if (s1.charAt(pos1) == s2.charAt(pos2)) {
//             longest = 1 + dfs(s1,s2, pos1-1, pos2-1);
//         } else {
//             longest = Math.max(dfs(s1,s2, pos1-1, pos2), dfs(s1,s2, pos1, pos2-1));
//         }
//         return dp[pos1][pos2] = longest;
//     }
}