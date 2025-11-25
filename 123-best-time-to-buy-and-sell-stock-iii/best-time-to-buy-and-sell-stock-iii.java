class Solution {
    public int maxProfit(int[] prices) {
        return maxProfitWithKTransactions(prices, 2);
    }
    private int maxProfitWithKTransactions(int[] prices, int k) {
        int inf = (int) 1e9;

        int[] cost = new int[k + 1];
        int[] profit = new int[k + 1];

        Arrays.fill(cost, inf);

        for (int price : prices) {

            for (int i = 1; i <= k; i++) {
                cost[i] = Math.min(cost[i], price - profit[i - 1]);
                profit[i] = Math.max(profit[i], price - cost[i]);
            }
        }

        return profit[k];
    }
}