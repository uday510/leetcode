class Solution {
    public int minCostII(int[][] costs) {

        if (costs.length == 0) return 0;

        int n = costs.length;
        int k = costs[0].length;
        int[][] dp = new int[n][k];

        for (int j = 0; j < k; ++j) {
            dp[0][j] = costs[0][j];
        }

        for (int house = 1; house < n; ++house) {
            for (int col = 0; col < k; ++col) {
                int min = (int) 1e9;
                for (int prevCol = 0; prevCol < k; ++prevCol) {
                    if (col == prevCol) continue;

                    min = Math.min(min, costs[house][col] + dp[house - 1][prevCol]);
                }
                dp[house][col] = min;
            }
        }

        int minCost = (int) 1e9;
        for (int min : dp[n - 1]) minCost = Math.min(minCost, min);

        return minCost;
    }
}