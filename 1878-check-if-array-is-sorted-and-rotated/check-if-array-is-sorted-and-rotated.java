class Solution {
    public boolean check(int[] nums) {
        int idx = checkValid(0, nums);
        if (idx == nums.length) {
            return true;
        } 

        return checkValid(idx, nums) == nums.length && nums[0] >= nums[nums.length - 1];
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