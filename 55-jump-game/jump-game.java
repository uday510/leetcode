class Solution {
    public boolean canJump(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        return canJumpFromPos(0, nums, dp);
    }
    private boolean canJumpFromPos(int pos, int[] nums, int[] dp) {
        if (pos >= nums.length - 1) 
            return true;

        if (dp[pos] != -1) 
            return dp[pos] == 1 ? true : false;
        
        int farthestJump = Math.min(pos+nums[pos], nums.length-1);

        for (int nextJump = pos+1; nextJump <= farthestJump; ++nextJump) {
            if (canJumpFromPos(nextJump, nums, dp)) {
                dp[pos] = 1; 
                return true;
            }
        }
        dp[pos] = 0;
        return false;
    }
}