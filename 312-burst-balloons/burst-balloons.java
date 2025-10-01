class Solution {

    int[][] dp;
    int[] arr;
    int n;

    public int maxCoins(int[] nums) {
        n = nums.length;
        arr = new int[n + 2];
        dp = new int[n + 2][n + 2];

        arr[0] = arr[n + 1] = 1;
        for (int i = 1; i <= n; i++) {
            arr[i] = nums[i - 1];
        }

        return dfs(1, n);
    }

    private int dfs(int l, int r) {
        if (l < 0 || l > n || r < 0 || r > n) return 0;

        if (dp[l][r] != 0) return dp[l][r];

        int max = 0;
        for (int i = l; i <= r; i++) {
            int cur = (arr[i] * arr[l - 1] * arr[r + 1]) + dfs(l, i - 1) + dfs(i + 1, r);
            max = Math.max(cur, max);
        }
        
        return dp[l][r] = max;
    }
}

/**
 0  1  2  3  4  5 
[1, 3, 1, 5, 8, 1]

l = 1, r = 4

max = 0
cur = nums[i]*nums[l-1]*nums[r+1] + dfs(l, i - 1) + dfs(i + 1, r)


 */