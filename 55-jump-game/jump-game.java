class Solution {
    public boolean canJump(int[] nums) {
        int farthestPos = nums.length-1;

        for (int pos = nums.length-1; pos > -1; --pos) {
            if (pos + nums[pos] >= farthestPos) 
                farthestPos = pos;
        }
        return farthestPos == 0;
    }
}