class Solution {
    public int jump(int[] nums) {
        int N = nums.length;
        int[] dp = new int[N];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        
        for (int i = 0; i < N; ++i) {
            for (int j = i+1; j <= i + nums[i] && j < N; ++j) {
                dp[j] = Math.min(dp[j], dp[i]+1);
            }
        }
        return dp[N-1];
    }
}