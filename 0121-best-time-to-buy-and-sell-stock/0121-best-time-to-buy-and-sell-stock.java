class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minStock = prices[0];
        
        for (int price : prices) {
            minStock = Math.min(price, minStock);
            maxProfit = Math.max(price - minStock, maxProfit);
        }
        return maxProfit;
    }
}