class Solution {
    int[]dp;
    public int rob(int[] nums) {

        dp = new int[nums.length];

        Arrays.fill(dp, -1);

       return dfs(0, nums); 
    }
    private int dfs(int i, int[] nums) {
        if (i >= nums.length) {
            return 0;
        }

        if (dp[i] != -1) {
            return dp[i];
        }


        int take = nums[i] + dfs(i + 2, nums);
        int dont = dfs(i + 1, nums);
        return dp[i] = Math.max(take, dont);
    }
}