class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return dfs(0, 0, nums, target);
    }

    private int dfs(int curr, int idx, int[] nums, int target) {
        if (curr == target && idx == nums.length) return 1;
        if (idx >= nums.length) return 0;

        int pos = dfs(curr + nums[idx], idx + 1, nums, target);

        int neg = dfs(curr - nums[idx], idx + 1, nums, target);

        return pos + neg;
    }
}