class Solution {
    public boolean isMonotonic(int[] nums) {
        boolean isDecreasing = true;
        boolean isIncreasing = true;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] < nums[i]) isDecreasing = false;
            if (nums[i - 1] > nums[i]) isIncreasing = false;
        }

        return isDecreasing || isIncreasing;
    }
}