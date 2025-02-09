class Solution {
    Integer[][] memo;
    public int longestPalindromeSubseq(String s) {
        initialize(s);

        return dfs(0, s.length() - 1, s);
    }

    private int dfs(int leftIdx, int rightIdx, String s) {
        if (leftIdx > rightIdx) return 0;
        if (leftIdx == rightIdx) return 1;

        if (memo[leftIdx][rightIdx] != null) 
            return memo[leftIdx][rightIdx];

        if (s.charAt(leftIdx) == s.charAt(rightIdx)) {
            memo[leftIdx][rightIdx] = 2 + dfs(leftIdx + 1, rightIdx - 1, s);
        } else {
            memo[leftIdx][rightIdx] = Math.max(dfs(leftIdx + 1, rightIdx, s), dfs(leftIdx, rightIdx - 1, s));
        }

        return memo[leftIdx][rightIdx];
    }

    private void initialize(String s) {
        memo = new Integer[s.length()][s.length()];
    }
}