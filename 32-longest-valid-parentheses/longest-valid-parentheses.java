class Solution {
    public int longestValidParentheses(String s) {
        int n = s.length(), longest = 0;
        int[] dp = new int[n];

        for (int idx = 1; idx < n; ++idx) {
            if (s.charAt(idx) == '(') {
                continue;
            } else {
                if (s.charAt(idx - 1) == '(') {
                    dp[idx] = (idx > 1 ? dp[idx - 2] : 0) + 2;
                } else if (idx - dp[idx - 1] > 0 && s.charAt(idx - dp[idx - 1] - 1) == '(') {
                    dp[idx] = dp[idx - 1] +
                                (idx - dp[idx - 1] > 1 ? dp[idx - dp[idx - 1] - 2] : 0) + 2;
                }

                longest = Math.max(longest, dp[idx]);
            }
        }
        return longest;
    }
}

/**

    (  )  )  (  (  (  )  )
    0  1  2  3  4  5  6  7
dp  0  0  0  0  0  0  2  4


 */