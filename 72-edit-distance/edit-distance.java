class Solution {

    int m, n;
    String s1, s2;
    int[][] dp;

    public int minDistance(String w1, String w2) {
        m = w1.length();
        n = w2.length();
        s1 = w1;
        s2 = w2;
        dp = new int[m][n];

        for (int[] row : dp) Arrays.fill(row, -1);

        return dfs(0, 0);
    }

    private int dfs(int i, int j) {
        if (i >= m && j >= n) return 0;
        if (i >= m) return n - j;
        if (j >= n) return m - i;

        if (dp[i][j] != -1) return dp[i][j];

        if (s1.charAt(i) == s2.charAt(j)) {
            return dp[i][j] = dfs(i + 1, j + 1);
        } 

        int ins = dfs(i, j + 1);
        int del = dfs(i + 1, j);
        int repl = dfs(i + 1, j + 1);

        return dp[i][j] = 
            Math.min(ins, Math.min(del, repl)) + 1;
    }
}