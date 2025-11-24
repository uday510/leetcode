class Solution {

    public int maxProfit(int[] prices) {
        return maxProfitWithKTransactions(prices, 1);    
    }
    private int maxProfitWithKTransactions(int[] prices, int k) {
        
        int[] buy = new int[k + 1];
        int[] profit = new int[k + 1];
        Arrays.fill(buy, Integer.MAX_VALUE);

        for (int price : prices) {

            for (int i = 1; i <= k; i++) {
                // profit[i - 1] ==> profit from previous stock to reinvest
                buy[i] = Math.min(buy[i], price - profit[i - 1]);
                profit[i] = Math.max(profit[i], price - buy[i]);
            }

        }

        return profit[k];
    }
}