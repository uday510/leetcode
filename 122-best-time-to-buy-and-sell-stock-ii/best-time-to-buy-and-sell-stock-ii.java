class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;

        for (int idx = 1; idx < prices.length; ++idx) {
            int currProfit = Math.max(0, prices[idx] - prices[idx - 1]);
            maxProfit += currProfit;
        }

        return maxProfit;
    }
}