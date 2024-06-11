class Solution {
    public int removeElement(int[] nums, int val) {
        int index = 0;
        
        for (int num : nums) {
            if (num == val) {
                continue;
            }
            nums[index++] = num;
        }
        return index;
    }
}