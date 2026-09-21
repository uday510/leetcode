class Solution {
    public int jobScheduling(int[] st, int[] en, int[] pf) {
        int n = st.length;
        int[][] jobs = new int[n][3];
        int[] dp = new int[n + 1];

        for (int i = 0; i < n; i++) {
            jobs[i][0] = st[i];
            jobs[i][1] = en[i];
            jobs[i][2] = pf[i];
        }

        Arrays.sort(jobs, Comparator.comparingInt(k -> k[0]));

        for (int i = n - 1; i > -1; i--) {
            int nxt = bs(jobs, i + 1, n, jobs[i][1]);
            dp[i] = Math.max(dp[i + 1], jobs[i][2] + dp[nxt]);
        }

        return dp[0];
    }

    private int bs(int[][] jobs, int l, int r, int t) {
        
        while (l < r) {
            int m = l + ((r - l) >> 1);

            if (jobs[m][0] < t) l = m + 1;
            else r = m;
        }

        return l;
    }
}