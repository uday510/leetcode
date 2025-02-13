class Solution {
    public int longestArithSeqLength(int[] nums) {
        int len = nums.length;
        Map<Integer, Integer>[] dp = new HashMap[len];
        int longest = 2;

        for (int right = 0; right < len; ++right) {
            dp[right] = new HashMap<>();
            for (int left = 0; left < right; ++left) {
                int diff = nums[right] - nums[left];
                dp[right].put(diff, dp[left].getOrDefault(diff, 1) + 1);

                longest = Math.max(longest, dp[right].get(diff));
            }
        }

        return longest;
    }
}