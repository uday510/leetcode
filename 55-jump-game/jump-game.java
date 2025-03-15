class Solution {
    int[] dp;
    public boolean canJump(int[] nums) {
        dp = new int[nums.length];
        Arrays.fill(dp, -1);
        return dfs(0, nums);
    }
    private boolean dfs(int pos, int[] nums) {
        if (pos > nums.length) return false;
        if (pos == nums.length - 1) return true;

        if (dp[pos] != -1) return dp[pos] == 1;

        int maxJump = pos + nums[pos];

        for (int nextPos = pos + 1; nextPos <= maxJump; ++nextPos) {
            if (dfs(nextPos, nums)) {
                dp[pos] = 1;
                return true;
            }
        }

        dp[pos] = 0;
        return false;
    }
}