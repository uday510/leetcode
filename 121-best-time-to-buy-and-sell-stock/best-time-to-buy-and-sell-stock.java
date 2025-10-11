class Solution {
    public int maxProfit(int[] prices) {
        int minBuy = prices[0];
        int maxProfit = 0;

        for (int price : prices) {
            minBuy = Math.min(price, minBuy);
            maxProfit = Math.max(price - minBuy, maxProfit);
        }

        return maxProfit;
    }
}