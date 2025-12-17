class Solution {
    public int maxProfit(int k, int[] prices) {
        
        return maxProfitWithKTransactions(k, prices);
    }

    private int maxProfitWithKTransactions(int k, int[] prices) {

        int[] costs = new int[k + 1];
        int[] profits = new int[k + 1];
        Arrays.fill(costs, Integer.MAX_VALUE);

        for (int price : prices) {

            for (int i = 1; i <= k; i++) {

                costs[i] = Math.min(costs[i], price - profits[i - 1]);
                profits[i] = Math.max(profits[i], price - costs[i]);
            }
        }

        return profits[k];
    }
}