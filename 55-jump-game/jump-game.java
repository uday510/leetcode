class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int lastPos = n - 1;

        for (int i = n - 1; i > -1; i--) {
            if (nums[i] + i >= lastPos) lastPos = i;
        }

        return lastPos == 0;
    }
}