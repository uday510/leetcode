class Solution {
    Integer[][] dp;
    public int minInsertions(String s) {
        dp = new Integer[s.length()][s.length()];
        return dfs(0, s.length() - 1, s);
    }

    private int dfs(int left, int right, String s) {
        if (left > right) return 0;

        if (dp[left][right] != null) return dp[left][right];

        if (s.charAt(left) == s.charAt(right)) {
            return dfs(left + 1, right - 1, s);
        }

        return dp[left][right] = Math.min(
            dfs(left, right - 1, s),
            dfs(left + 1, right, s)
        ) + 1;
    }
}