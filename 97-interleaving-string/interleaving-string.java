class Solution {

    String s1, s2, s3;
    Boolean[][] dp;
    int n, m, t;

    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) return false;

        this.s1 = s1;
        this.s2 = s2;
        this.s3 = s3;
        n = s1.length();
        m = s2.length();
        t = s3.length();

        dp = new Boolean[n + 1][m + 1];  

        return dfs(0, 0);  
    }

    private boolean dfs(int i, int j) {
        if (i == n && j == m) return true;

        if (dp[i][j] != null) return dp[i][j];

        int k = i + j;
        boolean ok = false;

        if (i < n && s1.charAt(i) == s3.charAt(k)) {
            ok |= dfs(i + 1, j);
        }

        if (j < m && s2.charAt(j) == s3.charAt(k)) {
            ok |= dfs(i, j + 1);
        }

        return dp[i][j] = ok;
    }
}