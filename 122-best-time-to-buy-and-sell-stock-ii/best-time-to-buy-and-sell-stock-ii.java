class Solution {
    int[] memo;
    public int maxProfit(int[] prices) {
        memo = new int[prices.length];

        Arrays.fill(memo, -1);

        return dfs (0, prices);
    }
    private int dfs(int i, int[] prices) {
        if (i >= prices.length) {
            return 0;
        }

        if (memo[i] != -1) {
            return memo[i];
        }

        int maxProfit = -1;

        for (int j = i; j < prices.length; ++j) {
            if (prices[j] > prices[i]) {
                maxProfit = Math.max(maxProfit, prices[j] - prices[i] + dfs(j + 1, prices));
            }
        }

        maxProfit = Math.max(maxProfit, dfs(i + 1, prices));

        return memo[i] = maxProfit;
    }
}