class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        
        int n = s1.length();
        int m = s2.length();

        int[][] dp = new int[n][m];
        for (int[] r : dp) Arrays.fill(r, -1);

        return dfs(0, 0, n, m, s1, s2, dp);
    }

    private int dfs(int i, int j, int n, int m, String s1, String s2, int[][] dp) {
        if (i >= n && j >= m) return 0;

        if (i >= n) return ok(j, m, s2);
        if (j >= m) return ok(i, n, s1);

        if (dp[i][j] != -1) return dp[i][j];

        int cur;
        if (s1.charAt(i) == s2.charAt(j)) {
            cur = dfs(i + 1, j + 1, n, m, s1, s2, dp);
        } else {
            cur = Math.min(
                s1.charAt(i) + dfs(i + 1, j, n, m, s1, s2, dp),
                s2.charAt(j) + dfs(i, j + 1, n, m, s1, s2, dp)
            );
        }

        return dp[i][j] = cur;
    }

    private int ok(int idx, int n, String s) {

        int cur = 0;
        while (idx < n) {
            cur += s.charAt(idx++);
        }

        return cur;
    }
}