class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minPrice = Integer.MAX_VALUE;

        for (int i = 0; i < prices.length; ++i) {
            minPrice = Math.min(minPrice, prices[i]);

            if (i + 1 < prices.length && prices[i+1] < prices[i]) {
                maxProfit += prices[i] - minPrice;
                minPrice = Integer.MAX_VALUE;
            } 
        }
        return maxProfit += prices[prices.length-1] - minPrice;
    }
}