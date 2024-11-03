class Solution {
    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 != 0) return false;
        int n = nums.length;
        int[][] dp = new int[n][sum/2+1];

        for (int[] row : dp)
            Arrays.fill(row, -1);

        return dfs(0, 0, sum/2, n, nums, dp);
    }
    boolean dfs(int i, int sum, int target, int n, int[] nums, int[][] dp) {
        if (sum == target) return true;
        if (i >= n || sum > target) return false;
        if (dp[i][sum] != -1) return dp[i][sum] == 1;

        boolean inc = dfs(i + 1, sum + nums[i], target, n, nums, dp);
        boolean exc = dfs(i + 1, sum, target, n, nums, dp);

        dp[i][sum] = inc || exc ? 1 : 0;

        return dp[i][sum] == 1;
    }
}