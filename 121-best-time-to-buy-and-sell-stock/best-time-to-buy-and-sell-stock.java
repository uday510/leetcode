class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int costPrice = prices[0];

        for (int sellingPrice : prices) {
            maxProfit = Math.max(maxProfit, sellingPrice - costPrice);
            costPrice = Math.min(costPrice, sellingPrice);
        }
        return maxProfit;
    }
}