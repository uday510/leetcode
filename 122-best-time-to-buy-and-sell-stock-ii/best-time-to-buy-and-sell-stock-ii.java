class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;

        for (int idx = 1; idx < prices.length; ++idx) {
           profit += Math.max(0, prices[idx] - prices[idx - 1]);
        }

        return profit;
    }
}