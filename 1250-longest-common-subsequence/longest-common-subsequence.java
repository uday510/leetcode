class Solution {
    public int longestCommonSubsequence(String t1, String t2) {
        
        
        int[][] dp = new int[t1.length()][t2.length()];

        for (int[] r : dp) Arrays.fill(r, -1);

        return dfs(0, 0, t1.length(), t2.length(), t1, t2, dp);
    }

    private int dfs(int i, int j, int n, int m, String t1, String t2, int[][] dp) {

        if (i >= n || j >= m) return 0;

        if (dp[i][j] != -1) return dp[i][j];

        if (t1.charAt(i) == t2.charAt(j)) {
            dp[i][j] = 1 + dfs(i + 1, j + 1, n, m, t1, t2, dp);
        } else {
            dp[i][j] =  Math.max(
                dfs(i + 1, j, n, m, t1, t2, dp),
                dfs(i, j + 1, n, m, t1, t2, dp)
            );
        }

        return dp[i][j];
    }
}

/**


 ab
 ba             1
0 ->  max  ( (i + 1, j) , (i, j + 1) )


 */