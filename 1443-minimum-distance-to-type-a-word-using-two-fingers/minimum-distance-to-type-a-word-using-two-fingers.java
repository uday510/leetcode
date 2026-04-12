class Solution {
   
    private int[][][] dp;
    private int n;

    public int minimumDistance(String word) {
        n = word.length();
        dp = new int[n][27][27];

        for (int i = 0; i < n; i++)
            for (int j = 0; j < 27; j++)
                Arrays.fill(dp[i][j], -1);
        
        return dfs(0, -1, -1, word);
    }

    private int dfs(int idx, int f1, int f2, String w) {
        if (idx >= n) return 0;

        if (dp[idx][f1 + 1][f2 + 1] != -1) return dp[idx][f1 + 1][f2 + 1];
        
        int cur = w.charAt(idx) - 'A';

        int c1 = getDist(cur, f1);
        int c2 = getDist(cur, f2);

        int t1 = c1 + dfs(idx + 1, cur, f2, w);
        int t2 = c2 + dfs(idx + 1, f1, cur, w);

        return dp[idx][f1 + 1][f2 + 1] = Math.min(t1, t2);

    }

    private int getDist(int a, int b) {
        if (a < 0 || b < 0) return 0;

        int x1 = a / 6, y1 = a % 6;
        int x2 = b / 6, y2 = b % 6;

        return Math.abs(x1 - x2) + Math.abs(y1 - y2);

    }


}