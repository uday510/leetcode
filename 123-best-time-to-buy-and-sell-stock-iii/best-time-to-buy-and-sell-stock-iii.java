class Solution {
    public int maxProfit(int[] prices) {
        int k = 2;
        int[] profits = new int[k];
        int[] costs = new int[k];
        Arrays.fill(costs, Integer.MAX_VALUE);

        for (int price : prices) {
            costs[0] = Math.min(price, costs[0]);
            profits[0] = Math.max(profits[0], price - costs[0]);

            for (int i = 1; i < k; ++i) {
                costs[i] = Math.min(costs[i], price - profits[i - 1]);
                profits[i] = Math.max(profits[i], price - costs[i]);
            }
        }

        return profits[k - 1];
    }
}