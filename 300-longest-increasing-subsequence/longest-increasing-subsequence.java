class Solution {
    int[][] dp;
    int[] arr;
    int n;
    public int lengthOfLIS(int[] nums) {
        arr = nums;
        n = arr.length;
        dp = new int[n + 1][n];
        for (int[] row : dp) Arrays.fill(row, -1);

        return dfs(-1, 0);
    }

    private int dfs(int i, int j) {
        if (j >= n) return 0;

        if (dp[i + 1][j] != -1) return dp[i + 1][j];

        int skip = dfs(i, j + 1);

        int take = 0;

        if (i == -1 || arr[i] < arr[j]) {
            take = 1 + dfs(j, j + 1);
        }

        return dp[i + 1][j] = Math.max(skip, take);
    }
}