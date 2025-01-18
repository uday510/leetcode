class Solution {
    public int removeDuplicates(int[] nums) {
        int count = 1;
        int index = 1;

        for (int idx = 1; idx < nums.length; ++idx) {
            if (nums[idx] == nums[idx - 1]) {
                count++;
            } else {
                count = 1;
            }

            if (count <= 1) {
                nums[index++] = nums[idx];
            }
        }

        return index;
    }
}