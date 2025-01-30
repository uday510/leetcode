class Solution {
    public int deleteAndEarn(int[] nums) {
        int maxVal = 0;

        for (int num : nums) {
            maxVal = Math.max(maxVal, num);
        }

        int[] freq = new int[maxVal + 1];
        for (int num : nums) {
            freq[num] += num;
        }
        
        int[] dp = new int[maxVal + 1];
        dp[1] = freq[1];

        for (int num = 2; num <= maxVal; ++num) {
            dp[num] = Math.max(dp[num - 1], freq[num] + dp[num - 2]);
        }

        return dp[maxVal];
    }
}