class Solution {
    int[] a1, a2;
    int[][] dp;
    int n, m;
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        a1 = nums1;
        a2 = nums2;
        n = a1.length;
        m = a2.length;
        dp = new int[n][m];

        for (int[] row : dp) Arrays.fill(row, -1);

        return dfs(0, 0);
    }
    private int dfs(int i, int j) {
        if (i >= n || j >= m) return 0;

        if (dp[i][j] != -1) return dp[i][j];

        
        if (a1[i] == a2[j]) {
            dp[i][j] = 1 + dfs(i + 1, j + 1);
        } else {
            dp[i][j] = Math.max(dfs(i + 1, j), dfs(i, j + 1));
        }

        return dp[i][j];
    }
}