class Solution {

    public int lengthOfLIS(int[] nums) {
        
        int n = nums.length;
        int[][] dp = new int[n + 1][n];

        for (int[] r : dp) Arrays.fill(r, -1);

        return dfs(-1, 0, n, nums, dp);
    }

    private int dfs(int p, int c, int n, int[] arr, int[][] dp) {
        if (c >= n || p >= n) return 0;

        if (dp[p + 1][c] != -1) return dp[p + 1][c];

        int skip = dfs(p, c + 1, n, arr, dp);
        int take = 0;

        if (p == -1 || arr[p] < arr[c]) {
            take = 1 + dfs(c, c + 1, n, arr, dp);
        }

        return dp[p + 1][c] = Math.max(skip, take);
    }

    
}