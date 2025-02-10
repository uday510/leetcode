class Solution {
    public int lengthOfLIS(int[] nums) {
        int longest = 1;
        int[] dp = new int[nums.length];

        for (int idx2 = 0; idx2 < nums.length; ++idx2) {
            dp[idx2] = 1;
            for (int idx1 = 0; idx1 < idx2; ++idx1) {
                if (nums[idx1] < nums[idx2]) {
                    dp[idx2] = Math.max(dp[idx2], dp[idx1] + 1);
                }
            }

            longest = Math.max(dp[idx2], longest);
        }

        return longest;
    }
}