class Solution {
    public int maxProfit(int k, int[] prices) {
        return maxProfitWithKTransactions(prices, k);
    }

    private int maxProfitWithKTransactions(int[] prices, int k) {

        int[] cost = new int[k + 1];
        int[] profit = new int[k + 1];

        int inf = (int) 1e9;
        Arrays.fill(cost, inf);

        for (int p : prices) {
            
            for (int i = 1; i <= k; i++) {
                cost[i] = Math.min(cost[i], p - profit[i - 1]);
                profit[i] = Math.max(profit[i], p - cost[i]);
            }
        }

        return profit[k];
    }
}