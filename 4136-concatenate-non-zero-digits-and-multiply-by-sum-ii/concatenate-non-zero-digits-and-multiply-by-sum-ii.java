class Solution {
    public int[] sumAndMultiply(String s, int[][] q) {
        
        long mod = (long) 1e9 + 7;
        int n = s.length();
        long[] pow = new long[n + 1];
        long[] cnt = new long[n + 1];
        long[] sum = new long[n + 1];
        long[] pre = new long[n + 1];

        pow[0] = 1;
        for (int i = 0; i < n; i++) {
            pow[i + 1] = pow[i] * 10 % mod;
            long d = s.charAt(i) - '0';

            sum[i + 1] = sum[i] + d;
            if (d != 0) {
                pre[i + 1] = (pre[i] * 10 + d) % mod;
                cnt[i + 1] = cnt[i] + 1;
            } else {
                pre[i + 1] = pre[i];
                cnt[i + 1] = cnt[i];
            }
        }


        int[] res = new int[q.length];

        for (int i = 0; i < q.length; i++) {
            int l = q[i][0], r = q[i][1];
            int c = (int) (cnt[r + 1] - cnt[l]);
            long p = pow[c];

            long multi = (pre[r + 1] - ((pre[l] * p) % mod) + mod) % mod;
            long sm = sum[r + 1] - sum[l];

            res[i] = (int) (multi * (sm % mod) % mod);
        }

        return res;

    }
}

