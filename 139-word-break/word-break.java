class Solution {

    String s;
    Set<String> words;
    int n;
    int[] dp;

    public boolean wordBreak(String s, List<String> wordDict) {
        this.s = s;
        this.n = s.length();
        words = new HashSet<>(wordDict);
        dp = new int[n];
        Arrays.fill(dp, -1);

        return dfs(0);    
    }

    private boolean dfs(int i) {
        if (i >= n) return true;;

        if (dp[i] != -1) return dp[i] == 1;

        for (int j = i; j < n; j++) {
            String substr = s.substring(i, j + 1);
            if (words.contains(substr) && dfs(j + 1)) {
                dp[i] = 1;
                return true;
            }
        }

        dp[i] = 0;

        return false;
    }
}