class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        
        int[] dp = new int[s.length()];
        Arrays.fill(dp, -1);

        return dfs(0, s.length(), s, new HashSet<>(wordDict), dp);
    }

    private boolean dfs(int i, int n, String s, Set<String> words, int[] dp){
        if (i >= n) return true;

        if (dp[i] != -1) return dp[i] == 1;

        for (int j = i; j < n; j++) {
            String sub = s.substring(i, j + 1);

            if (words.contains(sub) && dfs(j + 1, n, s, words, dp)) {
                dp[i] = 1;
                return true;
            }
        }

        dp[i] = 0;
        return false;
    }
}