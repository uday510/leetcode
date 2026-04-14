import java.util.*;

class Solution {

    private List<Integer> robots;
    private int[][] factory;
    private long[][] dp;
    private int n, m;

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

        long res = dfs(i, j + 1);

        long cur = 0;
        int curFactoryLimit = factory[j][1];
        for (int idx = 1; idx <= curFactoryLimit && i + idx - 1 < n; idx++) {
            
            cur += Math.abs(robots.get(i + idx - 1) - factory[j][0]);
            
            long t2 = dfs(i + idx, j + 1);
            if (t2 != Long.MAX_VALUE) {
                res = Math.min(res, cur + t2);
            }
            
        }


        return dp[i][j] = res;

    }
}