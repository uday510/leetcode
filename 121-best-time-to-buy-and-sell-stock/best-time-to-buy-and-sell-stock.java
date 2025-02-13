class Solution {
    public int maxProfit(int[] prices) {
      int maxProfit = 0;
      int minBuyingPrice = prices[0];

      for (int price : prices) {
        minBuyingPrice = Math.min(minBuyingPrice, price);
        maxProfit = Math.max(price - minBuyingPrice, maxProfit);
      }

      return maxProfit;
    }
}


