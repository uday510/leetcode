class Solution {

    private Set<Integer> travellingDays;
    private int n, lastDayOfTravel;
    private int[] costs;
    private int[] dp;

    public int mincostTickets(int[] days, int[] costs) {
        
        travellingDays = new HashSet<>();
        n = days.length;
        lastDayOfTravel = days[n - 1];
        this.costs = costs;
        dp = new int[lastDayOfTravel + 30];

        for (int d : days) travellingDays.add(d);
        Arrays.fill(dp, -1);

        return dfs(days[0]);
    }

    private int dfs(int d) {
        if (d > lastDayOfTravel) return 0;

        if (dp[d] != -1) return dp[d];

        if (!travellingDays.contains(d)) {
            return dfs(d + 1);
        }

        int p1 = costs[0] + dfs(d + 1);
        int p7 = costs[1] + dfs(d + 7);
        int p30 = costs[2] + dfs(d + 30);

        return dp[d] = Math.min(p1, Math.min(p7, p30));
    }
}