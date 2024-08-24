class Solution {
    Boolean[][] memo;
    public boolean stoneGame(int[] piles) {
        memo = new Boolean[piles.length][piles.length];
        return dfs(0, piles.length-1, 0, 0, piles);
    }
    public boolean dfs(int i, int j, int alice, int bob, int[] piles) {
        if (i > j) {
            return alice > bob;
        }
        if (memo[i][j] != null) {
            return memo[i][j];
        }
        
        boolean t1 = dfs(i+1,j-1, alice+piles[i], bob+piles[j], piles);
        boolean t2 = false;
        
        if (i+1 < piles.length) {
            t2 = dfs(i+1, j, alice+piles[i], bob+piles[i+1], piles);
        }
        
        boolean t3 = false;
        if (j-1 > -1) {
            t3 = dfs(i, j-2, alice+piles[j], bob+piles[j-1], piles);
        }
        
        return memo[i][j] = t1 || t2 || t3;
    }
}