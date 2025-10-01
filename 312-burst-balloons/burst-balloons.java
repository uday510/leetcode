class Solution {

    int[] arr;
    int[][] dp;

    public int maxCoins(int[] nums) {
        int n = nums.length;
        arr = new int[n + 2];
        dp = new int[n + 2][n + 2];

        arr[0] = arr[n + 1] = 1;

        for (int i = 0; i < n; i++) {
            arr[i + 1] = nums[i];
        }

        return dfs(1, n);
    }

    private int dfs(int l, int r) {
        if (l > r) return 0;

        if (dp[l][r] != 0) return dp[l][r];

        int max = 0;
        for (int i = l; i <= r; i++) {
            int cur = (arr[i] * arr[l - 1] * arr[r + 1]) + dfs(l , i - 1) + dfs(i + 1, r);
            max = Math.max(max, cur);
        }

        return dp[l][r] = max;
    }
}
