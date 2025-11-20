class Solution {

    Integer[] dp;
    int[] nums;
    int n;

    public int jump(int[] nums) {
        this.nums = nums;
        n = nums.length;
        dp = new Integer[n];
        n = nums.length;

        return dfs(0);
    } 

    private int dfs(int i) {
        if (i >= n - 1) return 0;

        if (dp[i] != null) return dp[i];

        int min = n;
        int m = Math.min(i + nums[i], n - 1);

        for (int j = i + 1; j <= m; ++j) {
            min = Math.min(min, 1 + dfs(j));
        }

        return dp[i] = min;
    }
}