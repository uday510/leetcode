class Solution {
    public int maxProfit(int[] prices) {
        return maxProfitWithKTransactions(1, prices);
    }

    private int maxProfitWithKTransactions(int k, int[] prices) {
        int[] buy = new int[k + 1];
        int[] profit = new int[k + 1];

        Arrays.fill(buy, Integer.MAX_VALUE);

        for (int p : prices) {

            for (int i = 1; i <= k; i++) {

                int profitFromPreviousTransaction = profit[i - 1];
                int effectiveCost = p - profitFromPreviousTransaction;
                buy[i] = Math.min(buy[i], effectiveCost);
                profit[i] = Math.max(profit[i], p - buy[i]);
            }
        }

        return profit[k];
    }
}