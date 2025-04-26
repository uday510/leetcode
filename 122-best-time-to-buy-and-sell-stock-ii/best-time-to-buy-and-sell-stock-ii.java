class Solution {

    int[] prices;
    int len;
    int[] dp;
    int maxProfit;

    public int maxProfit(int[] prices) {
      this.prices = prices;
      len = prices.length;
      dp = new int[len];
      Arrays.fill(dp, -1);
      maxProfit = 0;

      dfs(0);
      return maxProfit;
    }

    private int dfs(int idx) {
        if (idx >= len) return 0;
        if (dp[idx] != -1) return dp[idx];

        int currProfit = 0;
        for (int currIdx = idx; currIdx < len; ++currIdx) {
            currProfit = Math.max(currProfit, prices[currIdx] - prices[idx] + dfs(currIdx + 1));

            maxProfit = Math.max(maxProfit, currProfit);
        }

        return dp[idx] = maxProfit;
    }
}