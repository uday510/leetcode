class Solution {
    public int longestSubsequence(int[] arr, int difference) {
        int offset = 1_000_00;
        int[] dp = new int[2_000_01];
        int longest = 0;

        for (int x : arr) {
           int prevIdx = x - difference + offset;
           int currIdx = x + offset;

           dp[currIdx] = dp[prevIdx] + 1;
           longest = Math.max(longest, dp[currIdx]);
        }

        return longest;
    }
}