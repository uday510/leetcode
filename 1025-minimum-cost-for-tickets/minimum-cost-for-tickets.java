class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int n = days[days.length - 1];
        int[] dp = new int[n + 1];
        Set<Integer> travel = new HashSet<>();
        for (int d : days) travel.add(d);

        for (int i = 1; i <= n; i++) {
            if (!travel.contains(i)) {
                dp[i] = dp[i - 1];
            } else {
                int p1 = dp[Math.max(0, i - 1)] + costs[0];
                int p2 = dp[Math.max(0, i - 7)] + costs[1];
                int p3 = dp[Math.max(0, i - 30)] + costs[2];

                dp[i] = Math.min(p1, Math.min(p2, p3));
            }
        }

        return dp[n];
    }
}