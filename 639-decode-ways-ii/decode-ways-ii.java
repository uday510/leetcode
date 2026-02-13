class Solution {

    private String s;
    private int n;
    private long[] dp;
    private static final int mod = (int) 1e9 + 7;

    public int numDecodings(String s) {

        this.s = s;
        n = s.length();
        dp = new long[n];

        Arrays.fill(dp, -1);

        return (int) dfs(0);    
    }
    
    private long dfs(int i) {
        if (i >= n) return 1;

        if (dp[i] != -1) return dp[i];

        long cur = 0;
        char c1 = s.charAt(i);
        char c2 = i + 1 < n ? s.charAt(i + 1) : '#';

        if (c1 == '*') cur = 9 * dfs(i+ 1) % mod;
        else if (c1 >= '1') cur = dfs(i + 1) % mod;

        if (c2 == '#') return dp[i] = cur;


        if (c1 == '*') {
            if (c2 == '*') cur += 15 * dfs(i + 2) % mod;
            else if (c2 >= '0' && c2 <= '6') cur += 2 * dfs(i + 2) % mod;
            else cur += dfs(i + 2) % mod;
        } else if (c1 == '1') {
            if (c2 == '*') cur += 9 * dfs(i + 2) % mod;
            else cur += dfs(i + 2) % mod;
        } else if (c1 == '2') {
            if (c2 == '*') cur += 6 * dfs(i + 2) % mod;
            else if (c2 >= '0' && c2 <= '6') cur += dfs(i + 2) % mod;
        }

        return dp[i] = cur % mod;

    }
}