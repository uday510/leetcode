class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int n = nums.length;
        int[] rightMax = new int[n];
        rightMax[n - 1] = nums[n - 1];
        int suffixSum = nums[n - 1];

        for (int i = n - 2; i > -1; --i) {
            suffixSum += nums[i];

            rightMax[i] = Math.max(suffixSum, rightMax[i + 1]);
        }

        int prefixSum = 0;
        int max1 = nums[0];
        int max2 = nums[0];
        int curr = 0;

        for (int i = 0; i < n; ++i) {
            curr += nums[i];

            max1 = Math.max(max1, curr);
            curr = Math.max(curr, 0);

            prefixSum += nums[i];

            if (i + 1 < n) {
                max2 = Math.max(max2, prefixSum + rightMax[i + 1]);
            }
        }

        return Math.max(max1, max2);
    }
}