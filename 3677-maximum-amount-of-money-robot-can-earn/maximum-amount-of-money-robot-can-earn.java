class Solution {

    private Integer[][][] dp;
    private int[][] coins;
    private int n, m;

    public int maximumAmount(int[][] coins) {
        this.coins = coins;
        this.n = coins.length;
        this.m = coins[0].length;
        dp = new Integer[n][m][3];

        return dfs(0, 0, 2);
    }

    private int dfs(int i, int j, int k) {
        if (i == n - 1 && j == m - 1) {
            if (coins[i][j] >= 0) return coins[i][j];
            return k > 0 ? 0 : coins[i][j];
        }

        if (i >= n || j >= m) return Integer.MIN_VALUE;

        if (dp[i][j][k] != null) {
            return dp[i][j][k];
        }

        int cur = Math.max(dfs(i + 1, j, k),dfs(i, j + 1, k)) + coins[i][j];

        if (k > 0) {
            cur = Math.max(cur,
                        Math.max(
                            dfs(i + 1, j, k - 1),
                            dfs(i, j + 1, k - 1)
                        )
                    );
        }


        return dp[i][j][k] = cur;
    }

}

/**


[ 

    [0, 1, -1]
    [1, -2, 3]
    [2, -3, 4]

]


 */