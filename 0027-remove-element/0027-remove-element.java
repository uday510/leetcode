class Solution {
    public int removeElement(int[] nums, int val) {
        int index = 0;
        int k = 0;
        
        while (index < nums.length) {
            if (nums[index] == val) {
                index++;
                continue;
            }
            nums[k++] = nums[index++];
        }
        return k;
    }
}