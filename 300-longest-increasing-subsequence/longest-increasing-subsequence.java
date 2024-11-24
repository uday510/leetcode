class Solution {
    int[] memo;
    int len;

    public int lengthOfLIS(int[] nums) {
        len = nums.length;
        memo = new int[len];

        Arrays.fill(memo, -1);

        int max = 0;

        for (int idx = 0; idx < nums.length; ++idx) {
            max = Math.max(max, dfs(idx, nums));
        }

        return max;
    }

    private int dfs(int prevIdx, int[] nums) {
        if (memo[prevIdx] != -1) {
            return memo[prevIdx];
        }

        int maxLen = 1;

        for (int currIdx = prevIdx + 1; currIdx < len; ++currIdx) {
            if (nums[currIdx] > nums[prevIdx]) {
                maxLen = Math.max(maxLen, dfs(currIdx, nums) + 1);
            }
        }

        return memo[prevIdx] = maxLen;
    }
}