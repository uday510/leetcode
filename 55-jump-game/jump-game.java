class Solution {
    public boolean canJump(int[] nums) {
          int len = nums.length;
        boolean[] dp = new boolean[len];
        dp[len-1] = true;
        
        for (int i = len -2; i > -1; --i) {
            int farthestJump = Math.min(i + nums[i], len - 1);
            for (int j = i+1; j <= farthestJump; ++j) {
                if (dp[j])  {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[0];
    }
}