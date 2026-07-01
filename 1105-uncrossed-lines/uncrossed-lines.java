class Solution {

    public int maxUncrossedLines(int[] arr1, int[] arr2) {

        int n = arr1.length, m = arr2.length;
        int[][] dp = new int[n][m];
        
        for (int[] r : dp) Arrays.fill(r, -1);
        
        return dfs(0, 0, n, m, arr1, arr2, dp);
    }
    
    private int dfs(int i, int j, int n, int m, int[] arr1, int[] arr2, int[][] dp) {
        if (i >= n || j >= m) return 0;
        
        if (dp[i][j] != -1) return dp[i][j];
        
        if (arr1[i] == arr2[j]) {
            dp[i][j] = 1 + dfs(i + 1, j + 1, n, m, arr1, arr2, dp);
        } else {
            dp[i][j] = Math.max(
              dfs(i, j + 1, n, m, arr1, arr2, dp),
              dfs(i + 1, j, n, m, arr1, arr2, dp)      
            );
        }
        
        return dp[i][j];
    }
}