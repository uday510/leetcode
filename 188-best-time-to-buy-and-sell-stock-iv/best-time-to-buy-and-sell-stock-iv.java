class Solution {
    public int maxProfit(int k, int[] prices) {
        return maxProfitWithKTransactions(k, prices);
    }

    private int maxProfitWithKTransactions(int k, int[] prices) {
        int INF = Integer.MAX_VALUE;

        int[] cost = new int[k + 1];
        int[] profit = new int[k + 1];

        Arrays.fill(cost, INF);

        for (int p : prices) {

            for (int i = 1; i <= k; i++) {
                cost[i] = Math.min(cost[i], p - profit[i - 1]);
                profit[i] = Math.max(profit[i], p - cost[i]);
            }
        }

        return profit[k];
    }
}