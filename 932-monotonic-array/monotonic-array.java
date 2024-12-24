class Solution {
    public boolean isMonotonic(int[] nums) {
        int len = nums.length;
        boolean decreasing = true;
        boolean increasing = true; 

        for (int idx = 0; idx < len - 1; ++idx) {

            if (nums[idx] < nums[idx+1]) {
                decreasing = false;
            } 

            if (nums[idx] > nums[idx+1]) {
                increasing = false;
            }
        }

        return decreasing || increasing;
    }
}