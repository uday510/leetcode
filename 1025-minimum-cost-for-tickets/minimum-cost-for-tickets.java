class Solution {

    int[] days, costs, dp;
    int n;

    public int mincostTickets(int[] days, int[] costs) {
        this.days = days;
        this.costs = costs;
        this.n = days.length;
        this.dp = new int[n];
        Arrays.fill(dp, -1);
        return dfs(0);
    }

    private int dfs(int i) {
        if (i >= n) return 0;
        if (dp[i] != -1) return dp[i];

        int day1 = days[i] + 1;
        int day7 = days[i] + 7;
        int day30 = days[i] + 30;

        int j = i;
        while (j < n && days[j] < day1) j++;
        int cost1 = costs[0] + dfs(j);

        j = i;
        while (j < n && days[j] < day7) j++;
        int cost7 = costs[1] + dfs(j);

        j = i;
        while (j < n && days[j] < day30) j++;
        int cost30 = costs[2] + dfs(j);

        return dp[i] = Math.min(cost1, Math.min(cost7, cost30));
    }
}