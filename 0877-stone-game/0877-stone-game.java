class Solution {
    Boolean[][] dp;
    public boolean stoneGame(int[] piles) {
    //    dp = new Boolean[piles.length][piles.length];
    //    return dfs(piles, 0, 0, 0, piles.length-1); 
        return true;
    }
    public boolean dfs(int[] piles, int alice, int bob, int i, int j) {
        if (i > j) {
            return alice > bob;
        } 

        if (dp[i][j] != null) {
            return dp[i][j];
        }

        boolean p1 = dfs(piles, alice+piles[i], bob+piles[j], i+1, j-1);

        boolean p2 = dfs(piles, alice+piles[j], bob+piles[i], i+1, j-1);

        boolean p = p1 || p2;

        if (i+1 <= j) {
           p = p || dfs(piles, alice+piles[i], bob+piles[i+1], i+2, j);
        }
        
        if (i <= j-1) {
            p = p || dfs(piles, alice+piles[j], bob+piles[j-1], i, j-2);
        }

        return dp[i][j] = p;
    }
}