class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (p1, p2) -> p1[0] - p2[0]);
        int n = pairs.length;
        int[] dp = new int[n];
        int longest = 1;

        for (int i = 0; i < n; ++i) {
            dp[i] = 1;
            for (int j = 0; j < i; ++j) {
                if (pairs[j][1] < pairs[i][0]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            longest = Math.max(longest, dp[i]);
        }

        return longest;
    }
}