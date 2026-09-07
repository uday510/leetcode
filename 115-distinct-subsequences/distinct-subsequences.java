class Solution {
    public int numDistinct(String s, String t) {
        int n = s.length(), m = t.length();
        int[][] dp = new int[n][m];
        for (int[] r : dp)
            Arrays.fill(r, -1);

        return dfs(0, 0, s, t, n, m, dp);
    }

    private int dfs(int i, int j, String s, String t, int n, int m, int[][] dp) {
        if (j >= m) return 1;
        if (i >= n) return 0;

        if (dp[i][j] != -1) {
            return dp[i][j];
        }
            
        int cur = 0;
        if (s.charAt(i) == t.charAt(j)) {
            cur = dfs(i + 1, j + 1, s, t, n, m, dp) + 
                  dfs(i + 1, j, s, t, n, m, dp);
        } else {
            cur = dfs(i + 1, j, s, t, n, m, dp);
        }

        return dp[i][j] = cur;
    }
}