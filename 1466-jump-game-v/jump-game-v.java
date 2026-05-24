class Solution {

    private int n, d;
    private int[] arr, dp;

    public int maxJumps(int[] arr, int d) {
        n = arr.length;
        this.d = d;
        this.arr = arr;
        this.dp = new int[n];
        
        int mx = 0, n = arr.length;

        Arrays.fill(dp, -1);

        for (int i = 0; i < n; i++) {
            mx = Math.max(mx, dfs(i));
        }

        return mx;
    }


    private int dfs(int i) {
        if (i >= n) return 0;
        
        if (dp[i] != -1) return dp[i];

        int cur = 1;

        for (int j = i + 1; j <= i + d && j < n && arr[i] > arr[j]; j++) {
            cur = Math.max(cur, 1 + dfs(j));
        }

        for (int j = i - 1; j >= i - d && j > -1 && arr[i] > arr[j]; j--) {
            cur = Math.max(cur, 1 + dfs(j));
        }

        return dp[i] = cur;
    }
}