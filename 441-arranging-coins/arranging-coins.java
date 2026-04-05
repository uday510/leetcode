class Solution {
    public int arrangeCoins(int n) {
        if (n <= 1) return n;

        long l = 1, r = (long) n + 1;

        while (l < r) {
            long m = l + ( (r - l) >> 1);

            long coins = (long) ( m * (m + 1) / 2);

            if (coins <= n) l = m + 1;
            else r = m;
        }

        return (int) l - 1;
    }
}