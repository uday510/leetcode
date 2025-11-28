class Solution {

    private final int inf = (int) 1e9;

    public int maxProfit(int k, int[] prices) {
        return maxProfitWithKTransactions(prices, k);   
    }

    private int maxProfitWithKTransactions(int[] prices, int totalTransactions) {
        int[] cost = new int[totalTransactions + 1];
        int[] profit = new int[totalTransactions + 1];
        Arrays.fill(cost, inf);

        for (int price : prices) {

            for (int curTransaction = 1; curTransaction <= totalTransactions; curTransaction++) {
                
                cost[curTransaction] = Math.min(cost[curTransaction], price - profit[curTransaction - 1]);
                profit[curTransaction] = Math.max(profit[curTransaction], price - cost[curTransaction]);

            }
        }

        return profit[totalTransactions];
    }
}