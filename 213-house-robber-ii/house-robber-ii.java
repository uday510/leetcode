class Solution {

    int[] nums;
    int[][] dp;
    int len;
    
    public int rob(int[] nums) {
        initialize(nums);
        int start0 = dfs(1, 0);
        int start1 = dfs(0, 1);

        return Math.max(Math.max(start0, nums[nums.length - 1]), start1);
    }

    private void initialize(int[] nums) {
        this.nums = nums;
        this.len = nums.length;
        this.dp = new int[len][2];
        for (var arr : dp) {
            Arrays.fill(arr, -1);
        }
    }

    private int dfs(int start, int idx) {
        if (idx >= nums.length) {
            return 0;
        }

        if (idx == nums.length - 1) {
            if (start == 1) {
                return 0;
            }
        }

        if (dp[idx][start] != -1) {
            return dp[idx][start];
        }

        int pick = nums[idx] + dfs(start, idx + 2);
        int dont = dfs(start, idx + 1);

        return dp[idx][start] = Math.max(pick, dont);
    }
}