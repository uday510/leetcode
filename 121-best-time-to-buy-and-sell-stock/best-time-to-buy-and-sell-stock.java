class Solution {
    public int maxProfit(int[] prices) {
        int minPrice = prices[0], maxProfit = 0;

        for (int p : prices) {
            minPrice = Math.min(p, minPrice);
            maxProfit = Math.max(maxProfit, p - minPrice);
        }

        return maxProfit;
    }
}