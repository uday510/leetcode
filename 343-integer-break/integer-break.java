class Solution {

    int[] dp;

    public int integerBreak(int n) {
        if (n <= 3) return n - 1;
        
        dp = new int[n + 1];
        Arrays.fill(dp, -1);
        
        return dfs(n);
    }

    private int dfs(int n) {
        if (dp[n] != -1) return dp[n];

        int cur = 1;
        for (int i = 1; i <= n; i++) {
            cur = Math.max(cur, i * dfs(n - i));
        }

        return dp[n] = cur;
    }
}

/**

n = 5

dfs(5)


max = max, 1 * dfs(4) (4) = 4
    = max, 2 * dfs(3) (3) = 6
    = max, 3 * dfs(2) (2) = 6
    = max, 4 * dfs(1) (1) = 4
    = max, 5 * dfs(0) (1) = 5

dfs(4) = 4
    max = max, 1 * dfs(3) (2)
        = max, 2 * dfs(2) (2)
        = max, 3 * dfs(1) (1)
        = max, 4 * dfs(0) (1)


dfs(3) = 3
    max = max, 1 * dfs(2) (1)
        = max, 2 * dfs(1) (1)
        = max, 3 * dfs(0) (1)



dfs(2) = 2
    max = max, 1 * dfs(1) , 1
        = max, 2 * dfs(0) (1)

dfs(1) = 1
dfs(0) = 1

 */