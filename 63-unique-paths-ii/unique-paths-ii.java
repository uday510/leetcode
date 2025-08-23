class Solution {
    int m;
    int n;
    int[][] arr;
    int[][] dp;
    public int uniquePathsWithObstacles(int[][] arr) {
        m = arr.length;
        n = arr[0].length;
        this.arr = arr;
        dp = new int[m][n];

        for (int[] row : dp) Arrays.fill(row, -1);

        return dfs(0, 0);
    }

    private int dfs(int i, int j) {
        if (isOutOfBounds(i, j) || isObstacle(i, j)) return 0;
        if (isDestination(i, j)) return isObstacle(i, j) ? 0 : 1;
        if (isCached(i, j)) return dp[i][j];

        return dp[i][j] = dfs(i + 1, j) + dfs(i, j + 1);
    }

    private boolean isOutOfBounds(int i, int j) {
        return i >= m || j >= n;
    }

    private boolean isObstacle(int i, int j) {
        return arr[i][j] == 1;
    }

    private boolean isDestination(int i, int j) {
        return i == m - 1 && j == n - 1;
    }

    private boolean isCached(int i, int j) {
        return dp[i][j] != -1;
    }
}