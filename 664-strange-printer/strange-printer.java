class Solution {

    private int[][] dp;
    private String s;

    public int strangePrinter(String s) {
        this.s = removeDuplicates(s);
        int n = this.s.length();

        dp = new int[n][n];

        for (int[] r : dp) Arrays.fill(r, -1);

        return dfs(0, n - 1);
    }

    private int dfs(int st, int en) {
        if (st > en) return 0;
        if (st == en) return 1;


        if (dp[st][en] != -1) return dp[st][en];

        int cur = 1 + dfs(st + 1, en);

        for (int j = st + 1; j <= en; j++) {

            if (s.charAt(st) == s.charAt(j)) {

                cur = Math.min(cur, dfs(st + 1, j - 1) + dfs(j, en));
            }
            
        }

        return dp[st][en] = cur;
    }

    private String removeDuplicates(String s) {
        int n = s.length();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n;) {
            
            sb.append(s.charAt(i));

            char c = s.charAt(i);
            while (i < n && s.charAt(i) == c) i++;
        }

        return sb.toString();
    }
}