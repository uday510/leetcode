class Solution {
    public int waysToSplitArray(int[] nums) {
        int len = nums.length;
        int result = 0;
        int idx;
        long totalSum = 0;
        long currentSum = 0;

        for (idx = 0; idx < len; ++idx) {
            totalSum += (long) nums[idx];
        }

        for (idx = 0; idx < len - 1; ++idx) {
            currentSum += (long) nums[idx];
        
            if (currentSum >= (totalSum - currentSum)) {
                result += 1;
            }
        }

        return result;
    }
}