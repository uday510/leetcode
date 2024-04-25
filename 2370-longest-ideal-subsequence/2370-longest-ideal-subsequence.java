class Solution {
    public int longestIdealString(String s, int k) {
         int len = s.length();

        int[][] dp = new int[len][26];

        for(int i = 0; i < len; i++) {
            for(int j = 0; j < 26; j++) {
                dp[i][j] = -1;
            }
        }

        return dfs(s, k, 0, -1, dp);
    }
    public int dfs(String s, int k, int currIndex, int prev, int[][] seen) {
        if (currIndex == s.length()) {
            return 0;
        }

        if (prev != -1 && seen[currIndex][prev] != -1) {
            return seen[currIndex][prev];
        }


        int include = 0;

        if (prev == -1 || Math.abs(s.charAt(currIndex) - ('a' + prev)) <= k) {
            include = 1 + dfs(s, k, currIndex + 1, s.charAt(currIndex) - 'a', seen);
        }

        int exclude = dfs(s, k, currIndex + 1, prev, seen);

        int result = Math.max(include, exclude);

        if (prev != -1) {
            seen[currIndex][prev] = result;
        }

        return result;
    }
}