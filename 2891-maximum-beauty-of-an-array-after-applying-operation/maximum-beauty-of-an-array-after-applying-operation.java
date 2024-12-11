class Solution {
    public int maximumBeauty(int[] nums, int k) {
        Arrays.sort(nums);

        int result = 0;
        int len = nums.length;
        int curr = 0;

        for (int i = 0, j = 0; j < len; ++j) {
            curr += nums[j];

            while (i < j && (nums[j] - nums[i]) > 2*k) {
                curr -= nums[i];
                i++;
            }

            result = Math.max(result, j - i + 1);
        }

        return result;
    }
}

