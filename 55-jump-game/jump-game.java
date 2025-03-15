class Solution {
    public boolean canJump(int[] nums) {
        int lastPos = nums.length - 1;

        for (int idx = nums.length - 1; idx > -1; --idx) {
            if (idx + nums[idx] >= lastPos) 
                lastPos = idx;
        }

        return lastPos == 0;
    }
}