class Solution {

    String s;
    int[] dp;
    int n;

    public int numDecodings(String s) {
        this.s = s;
        n = s.length();
        dp = new int[n];
        Arrays.fill(dp, -1);
        
        return dfs(0);
    }

    private int dfs(int i) {
        if (i >= n) return 1;

        if (dp[i] != -1) return dp[i];

        if (s.charAt(i) == '0') return 0;

        int t1 = dfs(i + 1);
        int t2 = i + 1 < n && (s.charAt(i) - '0')*10 + (s.charAt(i + 1) - '0')<= 26 ? dfs(i + 2) : 0;

        return dp[i] = t1 + t2;

    }
}