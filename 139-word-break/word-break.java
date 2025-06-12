class Solution {

    Set<String> words;
    int[] dp;

    public boolean wordBreak(String s, List<String> wordDict) {
        words = new HashSet<>(wordDict);
        dp = new int[s.length()];
        Arrays.fill(dp, -1);
        return dfs(0, s);
    }

    private boolean dfs(int i, String s) {
        if (i >= s.length()) return true;

        if (dp[i] != -1) return dp[i] == 1;
        for (int j = i; j < s.length(); ++j) {
            if (words.contains(s.substring(i, j + 1))) {
                if (dfs(j + 1, s)) {
                    dp[i] = 1;
                    return true;
                }
            }
        }

        dp[i] = 0;
        return false;
    }
}