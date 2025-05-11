class Solution {
    public int longestValidParentheses(String s) {
        int n = s.length(), max = 0;
        int[] dp = new int[n];

        for (int idx = 1; idx < n; ++idx) {
            if (s.charAt(idx) == '(') {
                continue;
            }
            if (s.charAt(idx - 1) == '(') {
                dp[idx] = (idx > 1 ? dp[idx - 2] : 0) + 2;
            } else {
                if (idx - dp[idx - 1] > 0 && s.charAt(idx - dp[idx - 1] - 1) == '(') {
                    dp[idx] = dp[idx - 1] + 
                    (idx - dp[idx - 1] > 1 ? dp[idx - dp[idx - 1] - 2] : 0) + 2;
                }
            }
            max = Math.max(max, dp[idx]);
        }
        
        return max;
    }
}