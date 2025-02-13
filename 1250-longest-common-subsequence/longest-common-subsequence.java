class Solution {
    Integer[][] dp;
    public int longestCommonSubsequence(String text1, String text2) {
        dp = new Integer[text1.length()][text2.length()];
        return dfs(text1, text2, 0, 0);
    }

    private int dfs(String s1, String s2, int idx1, int idx2) {
        if (idx1 >= s1.length() || idx2 >= s2.length()) {
            return 0;
        }

        if (dp[idx1][idx2] != null) return dp[idx1][idx2];

        if (s1.charAt(idx1) == s2.charAt(idx2)) {
            return dp[idx1][idx2] = 1 + dfs(s1, s2, idx1 + 1, idx2 + 1);
        }

        return dp[idx1][idx2] = Math.max(
            dfs(s1, s2, idx1 + 1, idx2),
            dfs(s1, s2, idx1, idx2 + 1)
        );
    }
}