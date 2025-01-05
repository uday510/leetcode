class Solution {
    int[] nums;
    int[] dp;
    public int lengthOfLIS(int[] nums) {
        this.nums = nums;
        dp = new int[nums.length];

        Arrays.fill(dp, -1);

        int current = 0;
        for (int index = 0; index < nums.length; ++index) {
            current = Math.max(current, dfs(index));
        }

        return current;
    }

    private int dfs(int index) {
        if (dp[index] != -1) {
            return dp[index];
        }

        int currentLength = 1;

        for (int idx = index + 1; idx < nums.length; ++idx) {

            if (nums[index] < nums[idx]) {
                currentLength = Math.max(dfs(idx) + 1, currentLength);
            }
        }

        return dp[index] = currentLength;
    }
}