class Solution {

    int[][] dp;
    String s;
    String t;
    int len1;
    int len2;

    public int numDistinct(String s, String t) {
        initialize(s, t);
        return dfs(0, 0);
    }

    private int dfs(int idx1, int idx2) {
        if (idx2 >= len2) {
            return 1;
        }

        if (idx1 >= len1) {
            return 0;
        }

        if (dp[idx1][idx2] != -1) return dp[idx1][idx2];

        if (s.charAt(idx1) == t.charAt(idx2)) {
            dp[idx1][idx2] = dfs(idx1 + 1, idx2) + dfs(idx1 + 1, idx2 + 1);
        } else {
            dp[idx1][idx2] = dfs(idx1 + 1, idx2);
        }

        return dp[idx1][idx2];
    }

    private void initialize(String s, String t) {
        this.s = s;
        this.t = t;
        len1 = s.length();
        len2 = t.length();

        dp = new int[len1][len2];

        for (var arr : dp) 
            Arrays.fill(arr, -1);
    }
}