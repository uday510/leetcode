class Solution {
    int[][] jobs;
    int[] dp;
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        jobs = new int[n][3];
        dp = new int[n];
        Arrays.fill(dp, -1);

        for (int i = 0; i < n; ++i) {
          jobs[i][0] = startTime[i];
          jobs[i][1] = endTime[i];
          jobs[i][2] = profit[i];
        }
        
        Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);
        
        return dfs(0);
    }
     public int dfs(int i) {
        if (i == jobs.length) return 0;
        
        if (dp[i] != -1) return dp[i];
        int nextIndex = bs(jobs[i][1]);

        return dp[i] = Math.max(dfs(i+1), jobs[i][2] + dfs(nextIndex));
    
    }
    public int bs(int endTime) {
        int left = 0;
        int right = jobs.length;

        while (left < right) {
            int mid = (left + right) >> 1;
            int startTime = jobs[mid][0];

            if (endTime > startTime) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}