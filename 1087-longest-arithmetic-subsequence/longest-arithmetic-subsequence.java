class Solution {
    public int longestArithSeqLength(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer>[] dp = new HashMap[n];
        int longest = 0;
        
        for (int i = 0; i < n; ++i) {
            int prev = nums[i];
            dp[i] = new HashMap<>();
            dp[i].put(nums[i], 0);
            for (int j = 0; j < i; ++j) {
                int curr = nums[j];
                int diff = prev - curr;

                int toBeKeep = Math.max(dp[j].getOrDefault(diff, 0) + 1, dp[i].getOrDefault(diff, 0));
                dp[i].put(diff, toBeKeep);
                longest = Math.max(longest, toBeKeep);
            }
        }

        return longest + 1;
    }
}