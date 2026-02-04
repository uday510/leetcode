class Solution {

    private String s;
    private int[] dp;
    private int n;
    public int numDecodings(String s) {
        this.s = s;
        n = s.length();
        dp = new int[n];

        Arrays.fill(dp, -1);

        return dfs(0);
    }

    private int dfs(int idx) {
        if (idx >= n) return 1;

        if (dp[idx] != -1) return dp[idx];

        if (s.charAt(idx) == '0') return 0;

        int t1 = dfs(idx + 1);
        int t2 = idx + 1 < n && 
        (s.charAt(idx) - '0') * 10 + (s.charAt(idx + 1)) - '0' <= 26 ? dfs(idx + 2) : 0;

        return dp[idx] = t1 + t2;
    }
}