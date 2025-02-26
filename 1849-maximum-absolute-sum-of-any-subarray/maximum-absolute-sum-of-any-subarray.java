class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int currSum = nums[0];
        int maxSum = currSum;

        for (int idx = 1; idx < nums.length; ++idx) {
            currSum = Math.max(nums[idx], currSum + nums[idx]);
            maxSum = Math.max(maxSum, currSum);
        }

        currSum = nums[0];
        int minSum = currSum;

        for (int idx = 1; idx < nums.length; ++idx) {
            currSum = Math.min(nums[idx], currSum + nums[idx]);
            minSum = Math.min(currSum, minSum);
        }
        
        return Math.max(maxSum, Math.abs(minSum));
    }
}