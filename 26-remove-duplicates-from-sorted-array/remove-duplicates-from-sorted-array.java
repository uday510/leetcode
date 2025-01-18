class Solution {
    public int removeDuplicates(int[] nums) {
       int idx = 0;
       int index = 0;
       int len = nums.length;

       while (idx < len) {
            nums[index++] = nums[idx]; 
            int next = idx + 1;

            while (next < len && nums[idx] == nums[next]) {
                next++;
            }
            idx = next;
       } 

       return index;
    }
}