class Solution {
    public int maxProfit(int k, int[] prices) {
        return maxProfitWithKTransactions(k, prices);
    }

    private int maxProfitWithKTransactions(int k, int[] prices) {

        int[] cost = new int[k + 1];
        int[] profit = new int[k + 1];

        int inf = (int) 1e9;
        Arrays.fill(cost, inf);

        for (int p : prices) {
            
            for (int t = 1; t <= k; t++) {

                cost[t] = Math.min(cost[t], p - profit[t - 1]);
                profit[t] = Math.max(profit[t], p - cost[t]);
            }
        }

        return profit[k];
    }
}