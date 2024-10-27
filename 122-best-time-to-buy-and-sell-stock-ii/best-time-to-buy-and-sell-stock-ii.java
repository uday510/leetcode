class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;

        for (int idx = 1; idx < prices.length; ++idx) {
            if (prices[idx] - prices[idx-1] > 0) 
                maxProfit += (prices[idx] - prices[idx-1]);
        }
        return maxProfit;
    }
}