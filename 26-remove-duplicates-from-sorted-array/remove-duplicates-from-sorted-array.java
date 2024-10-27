class Solution {
    public int removeDuplicates(int[] nums) {
        int index = 0;
        int i = 0;

        while (i < nums.length) {
            if (nums[i] != nums[index]) {
                index++;
                nums[index] = nums[i];
            } else {
                i++;
            }
        }
        return index+1;
    }
}