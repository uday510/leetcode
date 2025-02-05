class Solution {
    public String longestPalindrome(String s) {
        int len = s.length();
        var dp = new boolean[len][len];

        int startIdx = 0;
        int endIdx = 0;

        for (int idx1 = len - 1; idx1 > -1; --idx1) {
            for (int idx2 = idx1 + 1; idx2 < len; ++idx2) {
                dp[idx1][idx2] = s.charAt(idx1) == s.charAt(idx2) && 
                                (idx2 - idx1 <= 2 || dp[idx1 + 1][idx2 - 1]);

                if (dp[idx1][idx2] && idx2 - idx1 > endIdx - startIdx) {
                    startIdx = idx1;
                    endIdx = idx2;
                }
            }
        }

        return s.substring(startIdx, endIdx + 1);
    }
}