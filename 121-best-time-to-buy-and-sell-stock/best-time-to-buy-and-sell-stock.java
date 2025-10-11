class Solution {
    public int maxProfit(int[] prices) {
        int minBuy = prices[0];
        int maxProfit = 0;

        for (int price : prices) {
            if (price < minBuy) {
                minBuy = price;
            }

            if (price - minBuy > maxProfit) {
                maxProfit = price - minBuy;
            }
        }

        return maxProfit;
    }
}