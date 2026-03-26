class Solution {

    private int[][] jobs;
    private int[] dp;
    private int n;

    public int jobScheduling(int[] st, int[] en, int[] pf) {
        n = st.length;
        jobs = new int[n][3];
        dp = new int[n]; 

        for (int idx = 0; idx < n; idx++) {
            dp[idx] = -1;
            jobs[idx][0] = st[idx];
            jobs[idx][1] = en[idx];
            jobs[idx][2] = pf[idx];
        }   

        Arrays.sort(jobs, Comparator.comparingInt(k -> k[0]));

        return dfs(0);
    }

    private int dfs(int i) {
        if (i >= n) return 0;

        if (dp[i] != -1) return dp[i];

        int t1 = dfs(i + 1);
        int t2 = jobs[i][2] + dfs(bs(i, jobs[i][1]));

        return dp[i] = Math.max(t1, t2);
    }

    private int bs(int l, int t) {
        int r = n;

        while (l < r) {
            int m = l + ((r - l) >> 1);

            if (jobs[m][0] < t) l = m + 1;
            else r = m;
        }

        return l;
    }
}