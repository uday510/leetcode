class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 0) return 0;

        int minStock = prices[0], maxProfit = 0;

        for (int price : prices) {
            minStock = Math.min(price, minStock);
            maxProfit = Math.max(maxProfit, price - minStock);
        }

        return maxProfit;
    }
}