class Solution {
    int[][] dp;
    int[] nums;
    int n, k, MIN;

    public int maxSumDivThree(int[] nums) {
        this.nums = nums;
        this.n = nums.length;
        this.k = 3;
        this.dp = new int[n][k];
        this.MIN = Integer.MIN_VALUE;

        for (int[] row : dp) Arrays.fill(row, MIN);

        return dfs(0, 0);
    }

    private int dfs(int i, int mod) {
        if (i == n) {
            return mod == 0 ? 0 : MIN;
        }

        if (dp[i][mod] != MIN) return dp[i][mod];

        int skip = dfs(i + 1, mod);

        int newMod = (mod + nums[i]) % 3;
        int take = nums[i] + dfs(i + 1, newMod);

        return dp[i][mod] = Math.max(skip, take);
    }
}