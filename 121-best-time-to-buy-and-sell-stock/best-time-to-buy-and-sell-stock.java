class Solution {
    public int maxProfit(int[] prices) {
        int k = 1;
        int n = prices.length;
        int[][] dp = new int[k + 1][n];


        for (int txn = 1; txn <= k; ++txn) {
            int max = -(int) 1e9;

            for (int day = 1; day < n; ++day) {
                
                if (dp[txn - 1][day - 1] - prices[day - 1] > max) {
                    max = dp[txn - 1][day - 1] - prices[day - 1];
                }

                if (max + prices[day] > dp[txn][day - 1]) {
                    dp[txn][day] = max + prices[day];
                } else {
                    dp[txn][day] = dp[txn][day - 1];
                }

            }
        }

        return dp[k][n - 1];
    }
}