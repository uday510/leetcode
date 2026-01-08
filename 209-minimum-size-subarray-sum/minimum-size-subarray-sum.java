class Solution {
    public int minSubArrayLen(int t, int[] nums) {
        
        if (Arrays.stream(nums).sum() < t) return 0;

        int n = nums.length;
        int res = n, cur = 0;

        for (int i = 0, j = 0; j < n; j++) {
            cur += nums[j];

            while (i <= j && cur >= t) {
                res = Math.min(res, j - i + 1);
                cur -= nums[i++];
            }

        }

        return res;
    }
}