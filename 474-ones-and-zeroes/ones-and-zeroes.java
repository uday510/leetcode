class Solution {
    int[][][] dp;
    int[][] s;
    int m, n;
    int len;
    public int findMaxForm(String[] strs, int m, int n) {
        len = strs.length;
        dp = new int[len][m + 1][n + 1];
        s = new int[len][2];
        this.m = m;
        this.n = n;

        for (int[][] twoD: dp) 
            for (int[] oneD: twoD) 
                Arrays.fill(oneD, -1);

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < strs[i].length(); j++) {
                if (strs[i].charAt(j) == '0') 
                    s[i][0]++;
                else s[i][1]++;
            }
        }

        return dfs(0, 0, 0);   
    }

    private int dfs(int i, int zeros, int ones) {
        if (i >= len) return 0;

        if (dp[i][zeros][ones] != -1) return dp[i][zeros][ones];

        int skip = dfs(i + 1, zeros, ones);
        int take = 0;

        if (s[i][0] + zeros <= m && s[i][1] + ones <= n) {
            take = 1 + dfs(i + 1, zeros + s[i][0], ones + s[i][1]);
        }

        return dp[i][zeros][ones] = Math.max(skip, take);
    }
}