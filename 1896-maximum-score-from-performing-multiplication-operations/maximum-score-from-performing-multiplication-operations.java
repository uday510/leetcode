class Solution {

    private Integer[][] dp;
    private int[] nums, multi;
    private int n, m;

    public int maximumScore(int[] nums, int[] multipliers) {
        this.nums = nums;
        this.multi = multipliers;
        n = nums.length;
        m = multi.length;
        this.dp = new Integer[m + 1][m + 1];

        return dfs(0, 0);
    }

    private int dfs(int l, int i) {
        
        int r = n - (i - l)- 1;
        
        if (i >= m || l > r) return 0;


        if (dp[l][i] != null) return dp[l][i];

        int p1 = nums[l] * multi[i] + dfs(l + 1, i + 1);
        int p2 = nums[r] * multi[i] + dfs(l, i + 1);

        return dp[l][i] = Math.max(p1, p2);
    }

}