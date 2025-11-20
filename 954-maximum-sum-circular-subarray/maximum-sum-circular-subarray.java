class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int total = 0;
        int curMax = 0, max = Integer.MIN_VALUE;
        int curMin = 0, min = Integer.MAX_VALUE;

        for (int num : nums) {
            curMax = Math.max(num, curMax + num);
            max = Math.max(max, curMax);

            curMin = Math.min(num, curMin + num);
            min = Math.min(min, curMin);

            total += num;
        }

        if (max < 0) return max;

        return Math.max(max, total - min);
    }
}