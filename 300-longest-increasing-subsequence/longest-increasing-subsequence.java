class Solution {
    int len;
    int[] memo;
    
    public int lengthOfLIS(int[] nums) {
        len = nums.length;
        memo = new int[len];

        Arrays.fill(memo, -1);

        int maxLen = 0;

        for (int index = 0; index < len; ++index) {
            maxLen = Math.max(maxLen, dfs(index, nums));
        }
        
        return maxLen;
    }

    private int dfs(int prevIdx, int[] nums) {
        if (memo[prevIdx] != -1) {
            return memo[prevIdx];
        }

        int currLen = 1;

        for (int currIdx = prevIdx; currIdx < len; ++currIdx) {

            if (nums[prevIdx] < nums[currIdx]) {
                currLen = Math.max(currLen, dfs(currIdx, nums) + 1);
            }
        }

        return memo[prevIdx] = currLen;
    }
}