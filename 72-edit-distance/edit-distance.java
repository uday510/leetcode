class Solution {
    String word1;
    String word2;
    int[][] dp;
    public int minDistance(String word1, String word2) {
        this.word1 = word1;
        this.word2 = word2;
        dp = new int[word1.length()][word2.length()];

        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }

        return dfs(0, 0);
    }

    private int dfs(int idx1, int idx2) {
        if (idx1 == word1.length() && idx2 == word2.length()) {
            return 0;
        }

        if (idx1 == word1.length()) {
            return word2.length() - idx2;
        }

        if (idx2 == word2.length()) {
            return word1.length() - idx1;
        }

        if (dp[idx1][idx2] != -1) {
            return dp[idx1][idx2];
        }

        if (word1.charAt(idx1) == word2.charAt(idx2)) {
            return dfs(idx1 + 1, idx2 + 1);
        }

        int insert = dfs(idx1, idx2 + 1) + 1;
        int delete = dfs(idx1 + 1, idx2) + 1;
        int replace = dfs(idx1 + 1, idx2 + 1) + 1;

        return dp[idx1][idx2] = Math.min(delete, Math.min(replace, insert));
    }
}

