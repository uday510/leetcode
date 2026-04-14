import java.util.*;

class Solution {

    private List<Integer> robots;
    private int[][] factory;
    private int n, m;
    private long[][] dp;

    public long minimumTotalDistance(List<Integer> robots, int[][] factory) {
        this.robots = robots;
        this.factory = factory;
        this.n = robots.size();
        this.m = factory.length;

        Collections.sort(robots);
        Arrays.sort(factory, Comparator.comparingInt(k -> k[0]));

        dp = new long[n][m];

        for (long[] row : dp) Arrays.fill(row, -1);

        return dfs(0, 0);
    }

    private long dfs(int i, int j) {
        if (i >= n) return 0;
        if (j >= m) return Long.MAX_VALUE;

        if (dp[i][j] != -1) return dp[i][j];

        long t1 = dfs(i, j + 1);

        long cost = 0;
        long t2 = Long.MAX_VALUE;

        for (int idx = 1; idx <= factory[j][1] && i + idx - 1 < n; idx++) {

            cost += Math.abs(factory[j][0] - robots.get((i + idx - 1)));

            long nxt = dfs(i + idx, j + 1);
            if (nxt != Long.MAX_VALUE) {
                t2 = Math.min(t2, cost + nxt);
            }

        }

        return dp[i][j] = Math.min(t1, t2);
    }
}