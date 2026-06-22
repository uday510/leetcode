class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int st = 0, en = 0;

        for (int i = n - 1; i > -1; i--) {
            for (int j = i + 1; j < n; j++) {
                dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i <= 2 || dp[i + 1][j - 1]);

                if (dp[i][j] && j - i > en - st) {
                    st = i;
                    en = j;
                }

            }
        }

        return s.substring(st, en + 1);
    }
}

/**

    r   a   c   e   c   a   r -> 7
        a   c   e   c   a  -> 5
            c   e   c -> 3



 */