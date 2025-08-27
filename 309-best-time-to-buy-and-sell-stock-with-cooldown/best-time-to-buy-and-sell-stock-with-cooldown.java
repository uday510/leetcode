class Solution {
    int[] p;
    int n;
    int[] dp;
    public int maxProfit(int[] prices) {
       p = prices;
       n = p.length; 
       dp = new int[n];
       Arrays.fill(dp, -1);
       return dfs(0); 
    }

    private int dfs(int i) {
        if (i >= n) return 0;

        if (dp[i] != -1) return dp[i];

        int skip = dfs(i + 1);

        int max = 0;
        for (int j = i + 1; j < n; ++j) {
            int curr = p[j] - p[i] + dfs(j + 2);
            max = Math.max(curr, max);
        }

        System.out.println(i + " : " + Math.max(skip, max));

        return dp[i] = Math.max(skip, max);
    }
}