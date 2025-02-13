class Solution {
    Map<String, Integer> dp;
    public int longestArithSeqLength(int[] nums) {
       int len = nums.length;
        int maxLength = 2;
        Map<Integer, Integer>[] dp = new HashMap[len];

       for (int right = 0; right < len; ++right) {
           dp[right] = new HashMap<>();
           for (int left = 0; left < right; ++left) {
              int diff = nums[right] - nums[left];
               dp[right].put(diff,dp[left].getOrDefault(diff, 1) + 1);

               maxLength = Math.max(maxLength, dp[right].get(diff));
           }
       }
        return maxLength;
    }

    private int dfs(int prevIdx, int currIdx, int diff, int[] nums) {
        if (currIdx >= nums.length) return 0;

        String key = prevIdx + "," + currIdx + "," + diff;

        if (dp.containsKey(key)) return dp.get(key);

        int skip = dfs(prevIdx, currIdx + 1, diff, nums);

        int pick = 0;
        if (prevIdx == -1) {
            for (int nextIdx = currIdx + 1; nextIdx < nums.length; ++nextIdx) {
                pick = Math.max(pick, 1 + dfs(currIdx, nextIdx, nums[nextIdx] - nums[currIdx], nums));
            }
        } else if (nums[currIdx] - nums[prevIdx] == diff) {
            pick = 1 + dfs(currIdx, currIdx + 1, diff, nums);
        }

       int result = Math.max(skip, pick);
       dp.put(key, result);

       return result;
    }
}