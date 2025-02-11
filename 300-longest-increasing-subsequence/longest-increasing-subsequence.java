class Solution {
    Integer[][] dp;
    public int lengthOfLIS(int[] nums) {
        dp = new Integer[nums.length + 1][nums.length];
        return dfs(-1, 0, nums);
    }

    private int dfs(int prevIdx, int currIdx, int[] nums) {
        if (currIdx >= nums.length) return 0;

        if (dp[prevIdx + 1][currIdx] != null) return dp[prevIdx + 1][currIdx];

        int skip = dfs(prevIdx, currIdx + 1, nums);

        int take = 0;
        if (prevIdx == -1 || nums[prevIdx] < nums[currIdx]) {
            take = 1 + dfs(currIdx, currIdx + 1, nums);
        }

        return dp[prevIdx + 1][currIdx] = Math.max(skip, take);
    }
}