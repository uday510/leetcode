class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int[][] dp = new int[k + 1][n];


        for (int txn = 1; txn <= k; ++txn) {

            for (int day = 1; day < n; ++day) {
                dp[txn][day] = dp[txn][day - 1];

                for (int prevDay = 0; prevDay < day; ++prevDay) {
                    dp[txn][day] = Math.max(dp[txn][day], dp[txn - 1][prevDay] + prices[day] - prices[prevDay]);
                }
             }
        }

        return dp[k][n - 1];
    }
}