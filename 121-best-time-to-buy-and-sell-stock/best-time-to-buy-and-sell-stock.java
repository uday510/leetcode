class Solution {
    public int maxProfit(int[] prices) {
        return maxProfitWithKTransactions(prices, 1);
    }

    private int maxProfitWithKTransactions(int[] prices, int k) {
    
        int[] profit = new int[k + 1];
        int[] buy = new int[k + 1];

        Arrays.fill(buy, (int) 1e9);

        for (int price : prices) {

            for (int i = 1; i <= k; i++) {

                // take from prev transaction profit as discount instead of buying at actual price

                int discount = price - profit[i - 1]; 
                buy[i] = Math.min(buy[i], discount);

                profit[i] = Math.max(profit[i], price - buy[i]);
            }
        }

        return profit[k];
    }
}