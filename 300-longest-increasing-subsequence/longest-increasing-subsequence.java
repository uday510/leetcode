class Solution {

    int n;
    int[][] dp;
    
    public int lengthOfLIS(int[] nums) {
        n = nums.length;
        dp = new int[n + 1][n];
        for (int[] row : dp) Arrays.fill(row, -1);

        return dfs(-1, 0, nums.length, nums);
    }
    private int dfs(int i, int j, int n, int[] nums) {
        if (j >= n) return 0;
        
        if (dp[i + 1][j] != -1) return dp[i + 1][j];

        int skip = dfs(i, j + 1, n, nums);

        int take = 0;

        if (i == -1 || nums[i] < nums[j]) {
            take = 1 + dfs(j, j + 1, n, nums);
        }


        return dp[i + 1][j] = Math.max(skip, take);
    }
}