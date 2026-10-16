class Solution {
    public boolean canJump(int[] arr) {
        
        int n = arr.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);

        return dfs(0, n, arr, dp);
    }

    private boolean dfs(int i, int n, int[] arr, int[] dp) {
        if (i == n - 1) return true;

        if (dp[i] != -1) return dp[i] == 1;
        
        int mx = Math.min(n - 1, i + arr[i]);
        for (int j = i + 1; j <= mx; j++) {
            if (dfs(j, n, arr, dp)) {
                dp[i] = 1;
                return true;
            }
        }

        dp[i] = 0;
        return false;
    }
}