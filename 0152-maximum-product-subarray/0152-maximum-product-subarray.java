class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int max = nums[0];
        for (int i = 0; i < n; ++i) {
            int curr = 1;
            for (int j = i; j < n; ++j) {
                curr *= nums[j];
                max = Math.max(curr, max);
            }
        }
        return max;
    }
}