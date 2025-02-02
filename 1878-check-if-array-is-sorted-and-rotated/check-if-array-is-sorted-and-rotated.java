class Solution {
    public boolean check(int[] nums) {
        
        int idx;
        int len = nums.length;
        int prev = nums[0];
        for (idx = 0; idx < len; ++idx) {
            int curr = nums[idx];
            if (prev > curr) {
                prev = curr;
                break;
            }
            prev = curr;
        }

        if (idx == len) {
            return true;
        }

        for (; idx < len; ++idx) {
            int curr = nums[idx];
            if (prev > curr) {
                return false;
            }
            prev = curr;
        }

        return nums[0] >= nums[len - 1];
    }
}