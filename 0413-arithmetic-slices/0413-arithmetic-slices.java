class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int total = 0;
        int curr = 0;
        int n = nums.length;
        
        for (int i = 2; i < n; ++i) {
            if (nums[i] - nums[i-1] == nums[i-1] - nums[i-2]) {
                curr += 1;
                total += curr;
            } else {
                curr = 0;
            }
        }
        return total;
    }
}