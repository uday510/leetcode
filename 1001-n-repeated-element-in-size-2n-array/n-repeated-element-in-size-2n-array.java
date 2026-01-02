class Solution {
    public int repeatedNTimes(int[] nums) {
        
        for (int i = 0; i < nums.length - 2; i++) {
            if (foundDuplicateNum(nums, i)) {
                return nums[i];
            }
        }

        return nums[nums.length - 1];
    }

    private boolean foundDuplicateNum(int[] nums, int idx) {
        return  nums[idx] == nums[idx + 1] || 
                nums[idx] == nums[idx + 2];
    }
}