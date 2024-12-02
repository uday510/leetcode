class Solution {
    public void moveZeroes(int[] nums) {
        int count = 0;

        for (int num : nums) {
            if (num == 0) {
                ++count;
            }
        }

        int index = 0;

        for (int idx = 0; idx < nums.length; ++idx) {
            if (nums[idx] != 0) {
                nums[index++] = nums[idx];
            }
        }

        for (; index < nums.length; ++index) {
            nums[index] = 0;
        }
    }
}