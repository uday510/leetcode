class Solution {
    public int maxProfit(int[] prices) {
        
        int len = prices.length;
        int[] dp = new int[len];

        for (int idx = 1; idx < prices.length; ++idx) {
            int price = prices[idx];
            dp[idx] = Math.max(dp[idx - 1], dp[idx - 1] + prices[idx] - prices[idx - 1]);
        }

        return dp[len - 1];
    }
}