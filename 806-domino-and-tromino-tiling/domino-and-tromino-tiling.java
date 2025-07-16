class Solution {
    public int numTilings(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
       int MOD = (int) 1e9 + 7;

       int dp1 = 1;
       int dp2 = 2;
       int dp3 = 5;

       for (int i = 4; i <= n; ++i) {
            int dp4 = ((2 * dp3) % MOD + dp1) % MOD;
            dp1 = dp2;
            dp2 = dp3;
            dp3 = dp4;
       }

       return dp3;
    }
}