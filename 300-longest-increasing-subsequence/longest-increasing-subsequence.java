class Solution {

    private int[][] dp;
    private int[] arr;
    private int n;

    public int lengthOfLIS(int[] nums) {
        this.arr = nums;
        n = arr.length;
        this.dp = new int[n][n + 1];
    
        for (int[] row : dp) Arrays.fill(row, -1); 

        return dfs(0, -1);
    }

    private int dfs(int cur, int prev) {
        if (cur >= n || prev >= n) {
            return 0;
        }

        if (dp[cur][prev + 1] != -1) {
            return dp[cur][prev + 1];
        }

        int skip = 0 + dfs(cur + 1, prev);

        int take = 0;

        if (prev == -1 || arr[prev] < arr[cur]) {
            take = 1 + dfs(cur + 1, cur);
        }

        return dp[cur][prev + 1] = Math.max(skip, take);
    }
}