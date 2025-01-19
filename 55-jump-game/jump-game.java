class Solution {
    public boolean canJump(int[] nums) {
        int len = nums.length;
        int pos = nums.length - 1;

        for (int idx = len - 1; idx > -1; --idx) {
            if (idx + nums[idx] >= pos) {
                pos = idx;
            }
        }

        return pos == 0;
    }
}