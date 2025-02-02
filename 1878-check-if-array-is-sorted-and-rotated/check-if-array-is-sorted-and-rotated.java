class Solution {
    public boolean check(int[] nums) {
        
        int idx = checkValid(0, nums);
        if (idx == nums.length) {
            return true;
        } 

        idx = checkValid(idx, nums);

        return idx == nums.length && nums[0] >= nums[nums.length - 1];
    }

    private int checkValid(int idx, int[] nums) {
        int prev = nums[idx];

        for (; idx < nums.length; ++idx) {
            int curr = nums[idx];
            if (prev > curr) {
                break;
            }

            prev = curr;
        }

        return idx;
    }
}