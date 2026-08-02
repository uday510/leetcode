class Solution {
    public boolean stoneGame(int[] piles) {
         int[] dp = new int[piles.length];
         
        for (int start = piles.length - 1; start > -1; --start) {
            dp[start] = piles[start];
            for (int end = start + 1; end < piles.length; ++end) {
                dp[end] = Math.max(piles[start] - dp[end], piles[end] - dp[end - 1]);
            }
        }
        return dp[piles.length - 1] > -1; 
    }
    
}