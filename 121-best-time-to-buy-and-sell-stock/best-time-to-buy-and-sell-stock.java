class Solution {
    public int maxProfit(int[] prices) {
        int minBuy = (int) 1e9;
        int maxProfit = 0;

        for (int price : prices) {
            minBuy = Math.min(minBuy, price);

            int currProfit = price - minBuy;
            if (currProfit > maxProfit) {
                maxProfit = currProfit;
            }

        }

        return maxProfit;
    }
}