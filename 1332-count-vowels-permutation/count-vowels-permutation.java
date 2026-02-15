class Solution {

    
    private static final int mod = (int) 1e9 + 7;

    public int countVowelPermutation(int n) {
        long a, e, i, o, u;
        a = e = i = o = u = 1;
        
        long a1, e1, i1, o1, u1;

        for (int idx = 2; idx <= n; idx++) {
            a1 = (e + i + u) % mod;
            e1 = (a + i) % mod;
            i1 = (o + e ) % mod;
            o1 = i % mod;
            u1 = (o + i) % mod;

            a = a1;
            e = e1;
            i = i1;
            o = o1;
            u = u1;
        }

        long total = (a + e + i + o + u) % mod;
        return (int) total;
    }
}