class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        
        if (Arrays.stream(nums).sum() < target) return 0;

        int n = nums.length;
        int res = n, curSum = 0;

        for (int i = 0, j = 0; j < n; j++) {
            curSum += nums[j];

            while (curSum >= target) {
                res = Math.min(res, j - i + 1);
                curSum -= nums[i++];
            }
        }

        return res;
    }
}