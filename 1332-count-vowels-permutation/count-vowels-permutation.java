class Solution {

    public int countVowelPermutation(int n) {
        long MOD = (int) 1e9 + 7;
        long a = 1, e = 1, i = 1, o = 1, u = 1;

        for (int idx = 2; idx <= n; ++idx) {
            long newA = (e) % MOD,
                 newE = (a + i) % MOD,
                 newI = (a + e + o + u) % MOD,
                 newO = (i + u) % MOD,
                 newU = a % MOD;

            a = newA % MOD; e = newE % MOD; i = newI % MOD; o = newO % MOD; u = newU % MOD;
        }

        return (int) ((a + e + i + o + u) % MOD);
    }
}