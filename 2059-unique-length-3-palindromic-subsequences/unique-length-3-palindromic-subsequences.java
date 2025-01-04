class Solution {
    public int countPalindromicSubsequence(String s) {
        int N = s.length();
        int[][] dp = new int[26][2];
        int res = 0;
        Set seen;

        for (int[] row : dp) Arrays.fill(row, -1);

        for (int i = 0; i < N; ++i) {
            int idx = s.charAt(i) - 'a';
            if (dp[idx][0] == -1) dp[idx][0] = i;
            dp[idx][1] = i;
        }

        for (int i = 0; i < 26; ++i) {
            if (dp[i][0] != -1) {
                seen = new HashSet<>();
                for (int j = dp[i][0]+1; j < dp[i][1]; ++j) {
                    char c = s.charAt(j);
                    if (!seen.contains(c)) {
                        seen.add(c);
                        res += 1;
                    }
                }
            }
        }
        return res;
    }
}