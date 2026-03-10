class Solution {

    private int[] nums, dp;
    private int n;

    public int jump(int[] nums) {

        this.nums = nums;
        this.n = nums.length;
        this.dp = new int[n];

        Arrays.fill(dp, -1);

        return dfs(0);    
    }

    private int dfs(int i) {
        if (i >= n - 1) return 0;
    
        if (dp[i] != -1) return dp[i];

        int mx = Math.min(i + nums[i], n - 1);

        int min = (int) 1e9;
        for (int j = i + 1; j <= mx; j++) {
            min = Math.min(min, 1 + dfs(j));
        }

        return dp[i] = min;
    }
}