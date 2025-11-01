class Solution {
    int[] dp;
    String s;
    int n;

    public int numDecodings(String s) {
        this.s = s;
        this.n = s.length();
        dp = new int[n];
        Arrays.fill(dp, -1);

        return dfs(0);
    }
    private int dfs(int i) {
      if (i >= n) return 1;

      if (s.charAt(i) == '0') return 0;
      
      if (dp[i] != -1) return dp[i];

       int t1 = dfs(i + 1);
       int t2 = i + 1 < n && num(i) * 10 + num(i + 1) <= 26 ? dfs(i + 2) : 0;

       return dp[i] = t1 + t2;
    }

    private int num(int i) {
        return s.charAt(i) - '0';
    }
}