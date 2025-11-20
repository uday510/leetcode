class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int n = nums.length;
        int curMin = n, curMax = 0;
        int min = n, max = nums[0];
        int total = 0;

        for (int num : nums) {
            curMin += num;
            curMax += num;

            min = Math.min(min, curMin);
            curMin = Math.min(curMin, 0);

            max = Math.max(max, curMax);
            curMax = Math.max(curMax, 0);

            total += num;
        }

        if (max < 0) return max;

        return Math.max(max, total - min);
    }
}