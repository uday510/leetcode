class Solution {

    int[] dp;

    public int jump(int[] nums) {
        dp = new int[nums.length];
        Arrays.fill(dp, -1);

        return dfs(nums, 0);
    }

    private int dfs(int[] nums, int pos) {
        if (pos >= nums.length - 1) return 0;

        if (dp[pos] != -1) return dp[pos];

        int minSteps = nums.length;
        int maxJump = Math.min(pos + nums[pos], nums.length - 1);

        for (int nxtJump = pos + 1; nxtJump <= maxJump; nxtJump++) {
            minSteps = Math.min(minSteps, 1 + dfs(nums, nxtJump));
        }

        return dp[pos] = minSteps;
    }
}