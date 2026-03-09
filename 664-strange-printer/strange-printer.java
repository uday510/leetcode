class Solution {

    Integer[][] dp;

    public int strangePrinter(String s) {
        // s = removeDuplicates(s);
        int n = s.length();
        dp = new Integer[n][n];
        return dfs(0, n - 1, s);
    }

    public int dfs(int i, int j, String s) {
        if (i > j) return 0;

        if (dp[i][j] != null) return dp[i][j];

        int min = 1 + dfs(i+1, j, s);
        for (int k = i + 1; k <= j; ++k) {
            if (s.charAt(k) == s.charAt(i)) {
                int sum = dfs(i, k-1, s) + dfs(k+1, j, s);
                min = Math.min(min, sum);
            }
        }
        dp[i][j] = min;
        return min;
    }

    public String removeDuplicates(String s) {
        StringBuilder sb = new StringBuilder();
        int n = s.length();
        
        for (int i = 0; i < n;) {
            char c = s.charAt(i);
            sb.append(c);

            int j = i + 1;
            while (j < n && s.charAt(j) == c) {
                ++j;
            }
            i = j;
        }
        return sb.toString();
    }
}