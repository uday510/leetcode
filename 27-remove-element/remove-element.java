class Solution {
    public int removeElement(int[] nums, int val) {
        int index = 0;

        for (int idx = 0; idx < nums.length; ++idx) {
            if (nums[idx] != val) {
                nums[index++] = nums[idx];
            }
        }

        return index;
    }
}