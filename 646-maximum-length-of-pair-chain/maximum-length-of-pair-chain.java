class Solution {

    public int findLongestChain(int[][] pairs) {
        
        Arrays.sort(pairs, (o1, o2) -> o1[0] - o2[0]);

        int n = pairs.length;
        int[][] dp = new int[n + 1][n];
        for (int[] r : dp) Arrays.fill(r, -1);

        return dfs(-1, 0, n, pairs, dp);
    }

    private int dfs(int p, int c, int n, int[][] arr, int[][] dp) {
        if (p >= n || c >= n) return 0;

        if (dp[p + 1][c] != -1) return dp[p + 1][c];

        int skip = dfs(p, c + 1, n, arr, dp);

        int take = 0;
        if (p == -1 || arr[p][1] < arr[c][0]) {
            take = 1 + dfs(c, c + 1, n, arr, dp);
        }

        return dp[p + 1][c] = Math.max(skip, take);
    }
}