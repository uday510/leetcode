class Solution {
    int[][] dp;
    int n;
    int m;
    int[] arr1;
    int[] arr2;
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        n = nums1.length;
        m = nums2.length;
        arr1 = nums1;
        arr2 = nums2;
        dp = new int[n][m];

        for (int[] row : dp) Arrays.fill(row,  -1);
        return dfs(0, 0);
    }
    private int dfs(int i, int j) {
        if (i >= arr1.length || j >= arr2.length) return 0;

        if (dp[i][j] != -1) return dp[i][j];

        if (arr1[i] == arr2[j]) {
            dp[i][j] = 1 + dfs(i + 1, j + 1);
        } else { 
            dp[i][j] = Math.max(dfs(i + 1, j), dfs(i, j + 1));
        }

        return dp[i][j];
    }
}