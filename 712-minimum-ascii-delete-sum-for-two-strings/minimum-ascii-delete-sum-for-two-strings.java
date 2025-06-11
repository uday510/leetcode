class Solution {
    int m;
    int n;
    int[][] dp;

    public int minimumDeleteSum(String s1, String s2) {
        m = s1.length();
        n = s2.length();
        dp = new int[m][n];

        for (var row : dp) Arrays.fill(row, -1);

        return dfs(0, 0, s1, s2);
    }

    private int dfs(int i, int j, String s1, String s2) {
        if (i >= m && j >= n) return 0;

        int curr = 0;
        if (i >= m) {
            for (; j < n; ++j) curr += s2.charAt(j);
            return curr;
        }

        if (j >= n) {
            for (; i < m; ++i) curr += s1.charAt(i);
            return curr;
        }

        if (dp[i][j] != -1) return dp[i][j];

        if (s1.charAt(i) == s2.charAt(j)) {
            dp[i][j] = dfs(i + 1, j + 1, s1, s2);
        } else {
            dp[i][j] = Math.min(
                s1.charAt(i) + dfs(i + 1, j, s1, s2),
                s2.charAt(j) + dfs(i, j + 1, s1, s2)
            );
        }

        return dp[i][j];
    }
}