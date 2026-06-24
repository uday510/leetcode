class Solution {

    public int lengthOfLIS(int[] nums) {
        
        int n = nums.length;
        int[][] dp = new int[n + 1][n];

        for (int[] r : dp) Arrays.fill(r, -1);

        return dfs(-1, 0, n, nums, dp);
    }

    private int dfs(int prev, int cur, int n, int[] arr, int[][] dp) {

        if (cur >= n || prev >= n) return 0;

        if (dp[prev + 1][cur] != -1) {
            return dp[prev + 1][cur];
        }

        int skip = dfs(prev, cur + 1, n, arr, dp);

        int take = 0;
        if (prev == -1 || arr[prev] < arr[cur]) {
            take = 1 + dfs(cur, cur + 1, n, arr, dp);
        }

        return dp[prev + 1][cur] = Math.max(skip, take);
    }
}