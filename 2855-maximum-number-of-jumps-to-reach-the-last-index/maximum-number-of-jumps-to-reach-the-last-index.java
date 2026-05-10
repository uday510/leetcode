class Solution {

    private int[] arr;
    int[][] dp;
    int t, n;

    public int maximumJumps(int[] arr, int t) {

        this.arr = arr;
        this.t = t;
        this.n = arr.length;

        dp = new int[n + 1][n];

        for (int[] r : dp) {
            Arrays.fill(r, Integer.MIN_VALUE);
        }

        int res = dfs(-1, 0);

        return res < 0 ? -1 : res;
    }

    private int dfs(int i, int j) {
        if (j >= n) {
            return i == n - 1 ? 0 : -(int) 1e9;
        }

        if (dp[i + 1][j] != Integer.MIN_VALUE) {
            return dp[i + 1][j];
        }

        int t1 = dfs(i, j + 1);

        int t2 = -(int) 1e9;

        if (
            (i == -1 && j == 0) ||
            (i != -1 && Math.abs(arr[j] - arr[i]) <= t)
        ) {
            int nxt = dfs(j, j + 1);

            // if (nxt >= 0) {
                t2 = (i == -1 ? 0 : 1) + nxt;
            // }

        }

        return dp[i + 1][j] = Math.max(t1, t2);
    }
}