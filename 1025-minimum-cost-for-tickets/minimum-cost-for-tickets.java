class Solution {

    int n;
    Set<Integer> days;
    int[] dp, c;

    public int mincostTickets(int[] _days, int[] costs) {
        n = _days[_days.length - 1];
        c = costs;
        days = new HashSet<>();
        dp = new int[n + 1];
        
        for (int d : _days) days.add(d);

        Arrays.fill(dp, -1);

        return dfs(_days[0]);
    }

    private int dfs(int i) {
        if (i > n) return 0;

        if (dp[i] != -1) return dp[i];
        if (!days.contains(i)) return dp[i] = dfs(i + 1);

        int p1 = c[0] + dfs(i + 1);
        int p2 = c[1] + dfs(i + 7);
        int p3 = c[2] + dfs(i + 30);

        return dp[i] = Math.min(p1, Math.min(p2, p3));
    }
}