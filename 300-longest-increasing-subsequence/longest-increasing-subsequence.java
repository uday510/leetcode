class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int longest = 1;

        for (int i = 0; i < n; ++i) {
            dp[i] = 1;

            for (int j = 0; j < i; ++j) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
            longest = Math.max(longest, dp[i]);
        } 
        return longest;

    }
}