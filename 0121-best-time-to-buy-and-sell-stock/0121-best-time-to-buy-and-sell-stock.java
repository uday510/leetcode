class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[] dp = new int[n];
        int minProfit = prices[0];
        
        for (int i = 1; i < prices.length; ++i) {
            dp[i] = Math.max(dp[i-1], prices[i] - minProfit);
            
            minProfit = Math.min(prices[i], minProfit);
        }
        
        return dp[n-1];
    }
}