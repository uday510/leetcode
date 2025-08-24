class Solution {
    int[][] pairs;
    int n;
    int[][] dp;
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (o1, o2) -> o1[0] - o2[0]);
        this.pairs = pairs;
        n = pairs.length;
        dp = new int[n + 1][n];

        for (int[] row : dp) Arrays.fill(row, -1);

        return dfs(-1, 0);
    }
    private int dfs(int i, int j) {
        if (j >= n) return 0;

        if (dp[i + 1][j] != -1) return dp[i + 1][j];

        int skip = dfs(i, j + 1);

        int take = 0;

        if (i == -1 || pairs[i][1] < pairs[j][0]) {
            take = 1 + dfs(j, j + 1);
        }

        return dp[i + 1][j] = Math.max(skip, take);
    }
}