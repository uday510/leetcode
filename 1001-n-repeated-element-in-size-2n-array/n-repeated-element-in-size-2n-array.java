class Solution {
    public int repeatedNTimes(int[] nums) {
        int i = 0, n = nums.length;

        while (i < n - 2) {
            if (foundRepeatedElement(nums, i)) {
                return nums[i];
            }
            
            i++;
        }

        return nums[n - 1];
    }

    private boolean foundRepeatedElement(int[] nums, int idx) {
        return  nums[idx] == nums[idx + 1] || 
                nums[idx] == nums[idx + 2];
    }
}