class Solution {
    public int longestArithSeqLength(int[] nums) {
        int n = nums.length;
        if (n <= 2) return n;

        Map<Integer, Integer>[] dp = new HashMap[n];
        int max = 1;

        for (int i = 0; i < n; ++i) {
            dp[i] = new HashMap<>();
            for (int j = 0; j < i; ++j) {
                int diff = nums[j] - nums[i];
                int len = dp[j].getOrDefault(diff, 1) + 1;
                int currMax = Math.max(dp[i].getOrDefault(diff, 0), len);
                dp[i].put(diff, currMax);
                max = Math.max(max, currMax);
            }
        }

        return max;
    }

}