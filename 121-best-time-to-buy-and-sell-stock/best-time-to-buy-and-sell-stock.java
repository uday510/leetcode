class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minBuy = Integer.MAX_VALUE;


        for (int price : prices) {
            minBuy = Math.min(minBuy, price);

            int curr = price - minBuy;
            maxProfit = Math.max(maxProfit, curr);
        }

        return maxProfit;
    }
}