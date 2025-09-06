class Solution {
    int[] dp;
    int[] nums;
    int t;
    public int combinationSum4(int[] nums, int target) {
        dp = new int[target + 1];
        this.nums = nums;
        t = target;
        Arrays.fill(dp, -1);

        return dfs(0);
    }

    private int dfs(int cur) {
        if (cur == t) return 1;
        if (cur > t) return 0;

        if (dp[cur] != -1) return dp[cur];

        int cnt = 0;
        for (int num : nums) {
            cnt += dfs(cur + num);
        }

        return dp[cur] = cnt;
    }
}