class Solution {

    Set<Integer> travellingDays;
    int lastDay;
    int[] dp;
    int[] c;

    public int mincostTickets(int[] days, int[] costs) {
        if (days.length == 0) return 0;

        travellingDays = new HashSet<>();
        dp = new int[days[days.length - 1] + 1];
        lastDay = days[days.length - 1];
        Arrays.fill(dp, -1);
        c = costs;

        for (int day : days) travellingDays.add(day);    

        return dfs(0);
    }
    private int dfs(int day) {
        if (day > lastDay) return 0;

        if (dp[day] != -1) return dp[day];

        if (!travellingDays.contains(day)) return dp[day] = dfs(day + 1);

        int day1 = c[0] + dfs(day + 1);
        int day7 = c[1] + dfs(day + 7);
        int day30 = c[2] + dfs(day + 30);

        return dp[day] = Math.min(day1, Math.min(day7, day30));
    }
}