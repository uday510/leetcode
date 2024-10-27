class Solution {
    public int removeDuplicates(int[] nums) {
        int index = 0;
        int cnt = 1;

        for (int idx = 1; idx < nums.length; ++idx) {
            if (nums[idx] == nums[idx-1]) 
                ++cnt;
            else 
                cnt = 1;
            
            if (cnt <= 1) 
                nums[++index] = nums[idx];
        }
        return index + 1;
    }
}