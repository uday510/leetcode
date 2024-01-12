class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int max = nums[0];
        for (int i = n-1; i > -1; --i) {
            int curr = 1;
            for (int j = i; j < n; ++j) {
                curr *= nums[j];
                max = Math.max(curr, max);
            }
        }
        return max;
    }
}