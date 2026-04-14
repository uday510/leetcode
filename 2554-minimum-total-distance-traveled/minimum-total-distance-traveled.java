class Solution {

    private List<Integer> robot;
    private int[][] factory;
    private long[][] dp;

    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
        Collections.sort(robot);
        Arrays.sort(factory, Comparator.comparingInt(a -> a[0]));

        this.robot = robot;
        this.factory = factory;

        int n = robot.size();
        int m = factory.length;

        dp = new long[n][m];
        for (long[] row : dp) Arrays.fill(row, -1);

        return dfs(0, 0);
    }

    private long dfs(int i, int j) {
        // all robots assigned
        if (i == robot.size()) return 0;

        // no factories left
        if (j == factory.length) return (long) 1e15;

        if (dp[i][j] != -1) return dp[i][j];

        long res = dfs(i, j + 1); // skip this factory

        long cost = 0;

        // try assigning k robots to factory j
        for (int k = 1; k <= factory[j][1] && i + k - 1 < robot.size(); k++) {
            cost += Math.abs(robot.get(i + k - 1) - factory[j][0]);

            long next = dfs(i + k, j + 1);
            if (next != (long) 1e15) {
                res = Math.min(res, cost + next);
            }
        }

        return dp[i][j] = res;
    }
}