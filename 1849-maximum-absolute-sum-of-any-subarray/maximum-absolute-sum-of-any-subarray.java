class Solution {
    int kadane(int[] nums, int sign) {
        int maxSum = 0;
        int currSum = 0;

        for (int num : nums) {
            currSum += num * sign;
            maxSum = Math.max(maxSum, currSum);
            currSum = Math.max(currSum, 0);
        }

        return maxSum;
    }
    public int maxAbsoluteSum(int[] nums) {
        return Math.max(kadane(nums, 1), kadane(nums, -1));
    }
}