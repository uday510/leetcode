class Solution {
    public int jump(int[] nums) {
        int jumps = 0;
        int currentJumpEnd = 0;
        int farthestJump = 0;
        
        for (int i = 0; i < nums.length-1; ++i) {
            farthestJump = Math.max(i+nums[i], farthestJump);
            
            if (currentJumpEnd == i) {
                ++jumps;
                currentJumpEnd = farthestJump;
                
                if (currentJumpEnd <= i) {
                    return -1;
                }
            }
        }
        return jumps;
    }
}