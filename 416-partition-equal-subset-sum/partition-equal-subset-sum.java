class Solution {
    int[] nums;
    int[][] dp;
    int target;
    public boolean canPartition(int[] nums) {
        this.nums = nums;
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 != 0) return false;
        target = sum / 2;

        dp = new int[nums.length][sum];
        for (int[] row : dp) Arrays.fill(row, -1);

        return dfs(0, 0);
    }
    private boolean dfs(int i, int sum) {
        if (i >= nums.length) return false;
        if (sum == target) return true;

        if (dp[i][sum] != -1) return dp[i][sum] == 1;

        boolean exclude = dfs(i + 1, sum);

        boolean include = exclude || dfs(i + 1, sum + nums[i]);

        dp[i][sum] = (exclude || include ? 1 : 0);
        return dp[i][sum] == 1;
    }
}