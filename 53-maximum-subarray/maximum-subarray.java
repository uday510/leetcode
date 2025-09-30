class Solution {
    public int maxSubArray(int[] nums) {
        int curSum = 0, maxSum = nums[0];

        for (int num : nums) {
            curSum += num;
            maxSum = Math.max(maxSum, curSum);
            curSum = Math.max(0, curSum);

        }

        return maxSum;
    }
}