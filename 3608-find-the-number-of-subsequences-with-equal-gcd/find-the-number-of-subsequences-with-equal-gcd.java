class Solution {

    static Map<Long, Integer> cache = new HashMap<>();

    public int subsequencePairCount(int[] arr) {
        int n = arr.length;
        int m = -1;
        for (int a : arr)
            m = Math.max(m, a);

        long[][][] dp = new long[n][m + 1][m + 1];

        for (long[][] d : dp)
            for (long[] r: d)
                Arrays.fill(r, -1L);

        return (int) dfs(0, 0, 0, n, arr, dp, (long) 1e9 + 7);
    }

    private long dfs(int i, int g1, int g2, int n, int[] arr, long[][][] dp, long mod) {
        if (i >= n) return (g1 > 0 && g1 == g2) ? 1 : 0;

        if (dp[i][g1][g2] != -1L)
            return dp[i][g1][g2];

        long t1 = dfs(i + 1, g1, g2, n, arr, dp, mod);
        long t2 = dfs(i + 1, gcd(g1, arr[i]), g2, n, arr, dp, mod);
        long t3 = dfs(i + 1, g1, gcd(g2, arr[i]), n, arr, dp, mod);

        long t = (t1 + t2 + t3) % mod; 

        return dp[i][g1][g2] = t;
    }

    private int gcd(int i, int j) {
        if (j == 0) return i;
        if (i == 0) return j;

        return gcd(j, i % j);
    }

} 