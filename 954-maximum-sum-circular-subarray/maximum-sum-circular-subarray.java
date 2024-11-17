class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        final int n = nums.length;
        int currMax = 0;
        int max = nums[0];
        int currMin = 0;
        int min = nums[0];
        int total = 0;

        for (int num : nums) {
            currMax += num;
            currMin += num;

            max = Math.max(max, currMax);
            currMax = Math.max(currMax, 0);

            min = Math.min(min, currMin);
            currMin = Math.min(currMin, 0);

            total += num;
        }

        if (max < 0) {
            return max;
        }

        return Math.max(max, total - min);
    }
}