class Solution {
    
    public int maxProfit(int k, int[] prices) {
        return maxProfitWithKTransactions(k, prices);
    }

    private int maxProfitWithKTransactions(int k, int[] prices) {
        int[] profit = new int[k + 1];
        int[] mn = new int[k + 1];

        Arrays.fill(mn, (int) 1e9);

        for (int p : prices) {

            for (int i = 1; i <= k; i++) {

                mn[i] = Math.min(mn[i], p - profit[i - 1]);

                profit[i] = Math.max(profit[i], p - mn[i]);

            }
        }

        return profit[k];
    }

}