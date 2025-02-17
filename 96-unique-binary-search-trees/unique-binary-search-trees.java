class Solution {
    public int numTrees(int n) {
        
        int[] dp = new int[n + 1];
        dp[0] = dp[1] = 1;
        for (int numNodes = 2; numNodes <= n; ++numNodes) {
            for (int root = 1; root <= numNodes; ++root) {
                dp[numNodes] += dp[root - 1] * dp[numNodes - root];
            }
        }

        return dp[n];
    }
}