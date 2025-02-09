class Solution {

    Integer[][] dp;
    int len1;
    int len2;

    public int minimumDeleteSum(String s1, String s2) {
        len1 = s1.length();
        len2 = s2.length();
        dp = new Integer[len1][len2];

        return dfs(0, 0, s1, s2);
    }

    private int dfs(int idx1, int idx2, String s1, String s2) {
        if (idx1 >= len1) {
            return getCount(idx2, s2);
        } else if (idx2 >= len2) {
            return getCount(idx1, s1);
        }

        if (dp[idx1][idx2] != null) {
            return dp[idx1][idx2];
        }

        if (s1.charAt(idx1) == s2.charAt(idx2)) {
            dp[idx1][idx2] = dfs(idx1 + 1, idx2 + 1, s1, s2);
        } else {
            int d1 = s1.charAt(idx1) + dfs(idx1 + 1, idx2, s1, s2);
            int d2 = s2.charAt(idx2) + dfs(idx1, idx2 + 1, s1, s2);

            dp[idx1][idx2] = Math.min(d1, d2);
        }

        return dp[idx1][idx2];
    }

    private int getCount(int idx, String s) {
        int current = 0;

        for (int index = idx; index < s.length(); ++index) {
            current += s.charAt(index);
        }

        return current;
    }
}