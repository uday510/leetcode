class Solution {
    int result = 0;
    public int findTargetSumWays(int[] nums, int target) {
        
        dfs(0, 0, nums, target);
        return result;
    }

    private void dfs(int index, int currSum, int[] nums, int target) {
        if (index >= nums.length) {
            result += currSum == target ? 1 : 0;
            return;
        }

       dfs(index + 1, currSum + nums[index], nums, target);
       dfs(index + 1, currSum - nums[index], nums, target);
    }
}